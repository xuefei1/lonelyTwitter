package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.Date;
import java.util.List;

/**
 * Created by watts1 on 1/26/16.
 */
public class TweetListTest extends ActivityInstrumentationTestCase2{
    public TweetListTest(){
        super(LonelyTwitterActivity.class);
    }

    public void testAddTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Test tweet");

        tweets.addTweet(tweet);

        assertTrue(tweets.hasTweet(tweet));
        try{
            tweets.addTweet(tweet);
            fail("IllegalStateException not thrown");
        }catch(IllegalStateException e){};
    }

    public void testHasTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Hello");

        assertFalse(tweets.hasTweet(tweet));

        tweets.addTweet(tweet);
        tweets.hasTweet(tweet);

        assertTrue(tweets.hasTweet(tweet));

        Tweet tweet2 = new NormalTweet("Hello2");
        assertFalse(tweets.hasTweet(tweet2));
        tweets.addTweet(tweet2);
        assertTrue(tweets.hasTweet(tweet2));

    }

    public void testDeleteTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Test tweet");

        tweets.addTweet(tweet);
        assertTrue(tweets.hasTweet(tweet));
        tweets.delete(tweet);

        assertFalse(tweets.hasTweet(tweet));
    }

    public void testGetTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Test tweet");

        tweets.addTweet(tweet);
        Tweet returnedTweet = tweets.getTweet(0);

        assertEquals(returnedTweet.getMessage(),tweet.getMessage());
        assertEquals(returnedTweet.getDate(),tweet.getDate());
    }

    @SuppressWarnings("deprecation")
    public void testGetTweets(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Test tweet");
        tweet.setDate(new Date(2016,1,1));
        Tweet tweet2 = new NormalTweet("Test tweet");
        tweet2.setDate(new Date(2016, 2, 1));
        tweets.addTweet(tweet);
        tweets.addTweet(tweet2);
        List<Tweet> result = tweets.getTweets();
        assertEquals(result.get(0).getDate().getMonth(), 1);
        assertEquals(result.get(1).getDate().getMonth(), 2);
    }

    public void testGetCount(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Test tweet");
        Tweet tweet2 = new NormalTweet("Test tweet");
        assertEquals(tweets.getCount(), 0);
        tweets.addTweet(tweet);
        assertEquals(tweets.getCount(), 1);
        tweets.addTweet(tweet2);
        assertEquals(tweets.getCount(), 2);
    }

}
