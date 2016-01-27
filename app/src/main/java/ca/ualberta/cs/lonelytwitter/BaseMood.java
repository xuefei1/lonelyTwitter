package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by xuefei1 on 1/12/16.
 */
public abstract class BaseMood {

    public abstract String getMood();

    public abstract Date getDate();

    public abstract  void setDate(Date d);
}
