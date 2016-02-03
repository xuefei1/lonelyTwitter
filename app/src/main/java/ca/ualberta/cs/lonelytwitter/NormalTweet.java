package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * class representing a normal tweet
 * @see Tweet
 * @see Tweetable
 */
public class NormalTweet extends Tweet implements Tweetable {
    /**
     * constructor for a normal tweet
     * @param date date the tweet is created on
     * @param message message associated with the tweet
     */
    public NormalTweet(Date date, String message) {
        super(date, message);
    }

    /**
     * Another constructor format where only the tweet message is required
     * @param message the tweet message
     */
    public NormalTweet(String message) {
        super(message);
    }

    /**
     *
     * @return the date that the tweet was created on
     */
    public Date getDate() {
        return this.date;
    }

    /**
     *
     * @return the tweet message
     */
    public String getMessage() {
        return this.message;
    }

    /**
     *
     * @return whether or not the tweet is important
     */
    @Override
    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}
