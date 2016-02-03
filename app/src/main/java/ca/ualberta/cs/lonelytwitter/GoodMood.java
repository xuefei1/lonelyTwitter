package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Goodmood class extends from BaseMood class
 * <p>
 * <p>This class inherits methods from BaseMood class and provide its own implementation</p>
 * @author Fred Han
 * @since 2016-02-02
 * @version 1.0
 * @see BaseMood
 */
public class GoodMood extends BaseMood {

    /**
     * private date variable representing the date that the tweet was created on
     */
    private Date date;

    /**
     * Constructer for the GoodMood class
     * <p>
     * Sets the date of the tweet
     * @param d set the date of the tweet to this variable
     */
    public GoodMood(Date d){
        this.date = new Date(d.getTime());
    }

    /**
     * Overrides the getdate method from the superclass,
     * return the date associated with this object
     * @return The date the this tweet is created on
     */
    @Override
    public Date getDate(){
        return this.date;
    }

    /**
     * Overrides the setdatemethod from the superclass,
     * @param date set the date of the tweet to this variable
     */
    @Override
    public void setDate(Date date){
        this.date = new Date(date.getTime());
    }

    /**
     * Overrides the getmood method from the superclass,
     * provides its own implementation of getmood
     *
     * @return String representing goodmood
     */
    @Override
    public String getMood() {
        return "GoodMood";
    }

}
