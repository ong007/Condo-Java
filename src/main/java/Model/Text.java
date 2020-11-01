package Model;

import java.util.ArrayList;

public class Text extends Item{
    private String level;
    private ArrayList<Text> userListText;

    public Text(){
        userListText = new ArrayList<>();
    }

    public Text(String receiver, String sender, String size, String company, String roomNumber, String dateTime, String level){
        super(receiver,sender,size,company,roomNumber,dateTime);
        this.level = level;
    }

    public void add(Text tr){
        userListText.add(tr);
    }
    public String getLevel() {
        return level;
    }
    public ArrayList<Text> getUserList() {
        return userListText;
    }
    public void removeText(Text text){
        userListText.remove(text);
    }

    public Text getListByRoomNum(String roomNum){
        String[] room = roomNum.split(" : ");
        Text list = new Text();
        for(Text text : userListText){
            if(text.getRoomnum().equals(room[0])){
                list.add(text);
            }
        }
        return list;
    }

}
