package Model;

import java.util.ArrayList;

public class Text extends Item{
    private String level;

    public Text(String receiver, String sender, String size, String company, String roomNumber, String dateTime, String level){
        super(receiver,sender,size,company,roomNumber,dateTime);
        this.level = level;
    }
    public String getLevel() {
        return level;
    }


}
