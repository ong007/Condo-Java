package Model;

import Controller.Text;

import java.util.ArrayList;

public class Textreader extends Item{
    private String level;
    private ArrayList<Textreader> userListText;

    public Textreader(){
        userListText = new ArrayList<>();
    }

    public Textreader(String receiver,String sender,String size,String company,String roomNumber,String dateTime,String level){
        super(receiver,sender,size,company,roomNumber,dateTime);
        this.level = level;
    }

    public void add(Textreader tr){
        userListText.add(tr);
    }
    public String getLevel() {
        return level;
    }
    public ArrayList<Textreader> getUserList() {
        return userListText;
    }
    public void removeText(Textreader text){
        userListText.remove(text);
    }

    public Textreader getListByRoomNum(String roomNum){
        String[] room = roomNum.split(" : ");
        Textreader list = new Textreader();
        for(Textreader text : userListText){
            if(text.getRoomnum().equals(room[0])){
                list.add(text);
            }
        }
        return list;
    }

}
