package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Badmood class extends from BaseMood class
 * <p>
 * <p>This class inherits methods from BaseMood class and provide its own implementation</p>
 * @author Fred Han
 * @since 2016-02-02
 * @version 1.0
 * @see BaseMood
 */
public class BadMood extends BaseMood {

    /**
     * private date variable representing the date that the tweet was created on
     */
    private Date date;


    /**
     * Constructer for the BadMood class
     * <p>
     * Sets the date of the tweet
     * @param date set the date of the tweet to this variable
     */
    public BadMood(Date date){
            this.date = new Date(date.getTime());
    }

    /**
     * Overrides the getmood method from the superclass,
     * provides its own implementation of getmood
     *
     * @return String representing badmood
     */
    @Override
    public String getMood() {
        return "BadMood";
    }

    /**
     * Overrides the getdate method from the superclass,
     * return the date associated with this object
     * @return The date the this tweet is created on
     */
    @Override
    public Date getDate() {
        return this.date;
    }

    /**
     * Overrides the setdate method from the superclass,
     * @param d set the date of the tweet to this variable
     */
    @Override
    public void setDate(Date d) {
        this.date = new Date(d.getTime());
    }

}
