package Model;

import java.util.ArrayList;

public class Boxreader extends Item{
    private String tacking;
    private String level;
    private ArrayList<Boxreader> userListBox;
    public Boxreader(){
        userListBox = new ArrayList<>();
    }
    public Boxreader(String receiver,String sender,String size,String company,String roomNumber,String dateTime,String level,String tacking){
        super(receiver,sender,size,company,roomNumber,dateTime);
        this.tacking = tacking;
        this.level = level;
    }
    public void add(Boxreader br){
        userListBox.add(br);
    }
    public ArrayList<Boxreader> getUserList() {
        return userListBox;
    }
    public void removeBox(Boxreader box){
        userListBox.remove(box);
    }
    public String getTacking() {
        return tacking;
    }
    public String getLevel() {
        return level;
    }
    public Boxreader getListByRoomNum(String roomNum){
        String[] room = roomNum.split(" : ");
        Boxreader boxList = new Boxreader();
        for(Boxreader box : userListBox){
            if(box.getRoomnum().equals(room[0])){
                boxList.add(box);
            }
        }
        return boxList;
    }
}
