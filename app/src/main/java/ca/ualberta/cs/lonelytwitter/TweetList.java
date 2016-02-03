package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

/**
 * Class representing a collection of tweets
 * @since 2015-02-02
 * @see ArrayList
 */
public class TweetList {

    /**
     * a list of tweets
     */
    private ArrayList<Tweet> tweets= new ArrayList<Tweet>();

    @Deprecated
    public void add(Tweet tweet){
            tweets.add(tweet);
    }

    /**
     * determine if a tweet is contained by this list
     * @param tweet tweet to look for
     * @return true of false
     */
    public boolean hasTweet(Tweet tweet){
        return tweets.contains(tweet);
    }

    /**
     * get tweet at a index
     * @param index
     * @return a tweet at index
     */
    public Tweet getTweet(int index){
        return tweets.get(index);
    }

    /**
     * remove a tweet
     * @param tweet tweet object to remove
     */
    public void delete(Tweet tweet){
        tweets.remove(tweet);
    }

    /**
     * return the number of tweets
     * @return the number of tweets
     */
    public int getCount(){
        return this.tweets.size();
    }

    /**
     * add a new tweet
     * @param tweet new tweet to add
     */
    public void addTweet(Tweet tweet){
        if(this.hasTweet(tweet)){
            throw new IllegalStateException();
        }else{
            tweets.add(tweet);
        }
    }

    /**
     *
     * @return the list of tweets
     */
    public ArrayList<Tweet> getTweets(){
        Collections.sort(tweets, new Comparator<Tweet>() {
            public int compare(Tweet lhs, Tweet rhs) {
                return lhs.getDate().compareTo(rhs.getDate());
            }
        });
        return tweets;
    }

}
