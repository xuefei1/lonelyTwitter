package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Base abstract providing a skeleton for different moods
 * @author Fred Han
 * @since 2016-02-02
 * @version 1.0
 */
public abstract class BaseMood {

    /**
     * Abstract method that should be overrided in the subclass with its own implementation
     * <p>
     * Returns a String representing the mood
     * @return String representing the mood
     */
    public abstract String getMood();

    /**
     * Abstract method that should be overrided in the subclass with its own implementation
     * <p>
     * Returns the date which the tweet is created
     * @return Date the the tweet is created
     */
    public abstract Date getDate();

    /**
     * Abstract method that should be overrided in the subclass with its own implementation
     * updates the date that the tweet was created on
     * @param d New date to change to
     */
    public abstract  void setDate(Date d);
}
