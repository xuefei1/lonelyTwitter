package ca.ualberta.cs.lonelytwitter;

import android.os.AsyncTask;
import android.util.Log;

import com.searchly.jestdroid.DroidClientConfig;
import com.searchly.jestdroid.JestClientFactory;
import com.searchly.jestdroid.JestDroidClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.searchbox.core.DocumentResult;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;

/**
 * Created by esports on 2/17/16.
 */
public class ElasticsearchTweetController {

    private static JestDroidClient client;

    //TODO: A function that gets tweets
    public static class GetTweetsTask extends AsyncTask<String, Void, ArrayList<Tweet>> {
        @Override
        protected ArrayList<Tweet> doInBackground(String...search_strings){
            verifyClient();

            ArrayList<Tweet> tweets = new ArrayList<Tweet>();

            Search search = new Search.Builder(search_strings[0]).addIndex("testing").addType("tweet").build();
            try {
                SearchResult execute = client.execute(search);
                if (execute.isSucceeded()) {
                    //Update ID of the tweet
                    List<NormalTweet> returned_tweets = execute.getSourceAsObjectList(NormalTweet.class);
                    tweets.addAll(returned_tweets);
                }else{
                    //TODO: Add a error message
                    Log.i("TODO", "Failed to add a tweet");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return tweets;
        }
    }
    //TODO: A function that adds a tweet

    public static class AddTweetTask extends AsyncTask<NormalTweet, Void, Void> {

        @Override
        protected Void doInBackground(NormalTweet... tweets){
            verifyClient();
            for(int i = 0; i < tweets.length; i++) {
                Index index = new Index.Builder(tweets[i]).index("testing").type("tweet").build();
                try {
                    DocumentResult result = client.execute(index);
                    if (result.isSucceeded()) {
                        //Update ID of the tweet
                        tweets[i].setId(result.getId());
                    }else{
                        //TODO: Add a error message
                        Log.i("TODO", "Failed to add a tweet");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }



    public static class SearchTweetTask  extends AsyncTask<String, Void, ArrayList<Tweet>> {

        @Override
        protected ArrayList<Tweet> doInBackground(String... patterns){
            verifyClient();
            ArrayList<Tweet> tweets = new ArrayList<Tweet>();
            for(int i = 0; i < patterns.length; i++) {

                String query = "{\n" +
                        "    \"query\": {\n" +
                        "                \"term\" : { \"message\" : \""+patterns[i]+"\" }\n" +
                        "            }\n" +
                        "}";
                Search search = new Search.Builder(query)
                        .addIndex("testing")
                        .addType("tweet")
                        .build();
                try {
                    SearchResult result = client.execute(search);
                    if(result.isSucceeded()){
                        Log.i("TODO", "Search successful");
                        List<NormalTweet> returned_tweets = result.getSourceAsObjectList(NormalTweet.class);
                        tweets.addAll(returned_tweets);
                    }else{
                        Log.i("TODO", "Failed to search");
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }

            }
            return tweets;
        }
    }

    public static void verifyClient(){
        // make the client if it does not exist
        if(client == null){
            DroidClientConfig.Builder builder = new DroidClientConfig.Builder("http://cmput301.softwareprocess.es:8080/");
            DroidClientConfig config = builder.build();
            JestClientFactory factory = new JestClientFactory();
            factory.setDroidClientConfig(config);
            client = (JestDroidClient) factory.getObject();
        }
    }
}
