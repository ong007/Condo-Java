package Model;

import java.util.ArrayList;

public class Box extends Item{
    private String tacking;
    private String level;

    public Box(String receiver, String sender, String size, String company, String roomNumber, String dateTime, String level, String tacking){
        super(receiver,sender,size,company,roomNumber,dateTime);
        this.tacking = tacking;
        this.level = level;
    }

    public String getTacking() {
        return tacking;
    }
    public String getLevel() {
        return level;
    }

}
