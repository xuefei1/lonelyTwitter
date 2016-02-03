package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Base abstract class representing a tweet
 */
public abstract class Tweet {
    /**
     * date the tweet was created on
     */
    protected Date date;
    protected String message;

    /**
     * abstract method telling whether the tweet is important
     * @return whether the tweet is important
     */
    public abstract Boolean isImportant();

    /**
     * contructor for a tweet object
     * @param date date the tweet is created on
     * @param message message associated with the tweet
     */
    public Tweet(Date date, String message) {
        this.date = date;
        this.message = message;
    }

    /**
     * Another constructor format where only the tweet message is required
     * @param message the tweet message
     */
    public Tweet(String message) {
        this.message = message;
        this.date = new Date();
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
    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > 140) {
            throw new TweetTooLongException();
        }
        this.message = message;
    }

    /**
     * update the date
     * @param date new date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * convert the tweet to a string
     * @return string representing a tweet
     */
    @Override
    public String toString(){
        return date.toString() + " | " + message;
    }
}
