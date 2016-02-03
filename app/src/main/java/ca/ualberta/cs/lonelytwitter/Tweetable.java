package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * interface representing a tweetable object
 */
public interface Tweetable {
    /**
     * @return the tweet message.
     */
    public String getMessage();

    /**
     * @return the tweet date
     */
    public Date getDate();
}
