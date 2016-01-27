package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by xuefei1 on 1/12/16.
 */
public class NoMood extends BaseMood {

    private Date date;

    public NoMood(Date date){
        this.date = new Date(date.getTime());
    }

    @Override
    public String getMood() {
        return "NoMood";
    }

    @Override
    public Date getDate() {
        return this.date;
    }

    @Override
    public void setDate(Date d) {
        this.date = new Date(d.getTime());
    }
}
