package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Class representing important tweet
 * @see Tweet
 * @see Tweetable
 */
public class ImportantTweet extends Tweet implements Tweetable {
    /**
     * determine if the tweet is important
     * @return Boolean representing whether it's important
     */
    @Override
    public Boolean isImportant() {
        return Boolean.TRUE;
    }

    /**
     * contructor for the Importatn tweet
     * @param date date the tweet was created
     * @param message tweet message
     */
    public ImportantTweet(Date date, String message) {
        super(date, message);
    }

    /**
     * Another constructor format where only the tweet message is required
     * @param message the tweet message
     */
    public ImportantTweet(String message) {
        super(message);
    }

    /**
     *
     * @return the date that the tweet is created
     */
    public Date getDate() {
        return this.date;
    }

    /**
     *
     * @return the tweet message
     */
    public String getMessage() {
        return "!IMPORTANT! " + this.message;
    }
}
