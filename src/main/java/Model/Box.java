package Model;

import java.util.ArrayList;

public class Box extends Item{
    private String tacking;
    private String level;
    private ArrayList<Box> userListBox;
    public Box(){
        userListBox = new ArrayList<>();
    }
    public Box(String receiver, String sender, String size, String company, String roomNumber, String dateTime, String level, String tacking){
        super(receiver,sender,size,company,roomNumber,dateTime);
        this.tacking = tacking;
        this.level = level;
    }
    public void add(Box br){
        userListBox.add(br);
    }
    public ArrayList<Box> getUserList() {
        return userListBox;
    }
    public void removeBox(Box box){
        userListBox.remove(box);
    }
    public String getTacking() {
        return tacking;
    }
    public String getLevel() {
        return level;
    }
    public Box getListByRoomNum(String roomNum){
        String[] room = roomNum.split(" : ");
        Box boxList = new Box();
        for(Box box : userListBox){
            if(box.getRoomnum().equals(room[0])){
                boxList.add(box);
            }
        }
        return boxList;
    }
}
