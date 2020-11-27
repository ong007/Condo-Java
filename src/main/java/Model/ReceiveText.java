package Model;

import java.util.ArrayList;

public class ReceiveText extends ReceiveMail{

    private String level;

    public ReceiveText(String sender, String username, String company, String roomnum, String level, String size, String time, String nameofficer){
        super(sender,username,company,roomnum,size,time,nameofficer);
        this.level = level;
    }
    public String getLevel() {
        return level;
    }
    public void setLevel(String level) {
        this.level = level;
    }

}
