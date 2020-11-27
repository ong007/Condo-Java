package Model;

import java.util.ArrayList;

public class ReceiveBox extends ReceiveMail{

    private String level;
    private String tracking;

    public ReceiveBox(String sender, String username, String company, String roomnum, String level, String size, String tracking, String time, String nameofficer)
    {
        super(sender,username,company,roomnum,size,time,nameofficer);
        this.level = level;
        this.tracking = tracking;

    }

    public String getLevel() {
        return level;
    }
    public void setLevel(String level) {
        this.level = level;
    }
    public String getTracking() {
        return tracking;
    }
    public void setTracking(String tracking) {
        this.tracking = tracking;
    }

}
