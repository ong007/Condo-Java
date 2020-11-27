package Model;

import javafx.scene.control.TableView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Item {
    private String username;
    private String size;
    private String company;
    private String room;
    private String roomnum;
    private String time;
    private String sender;
    private ArrayList<Item> items;
    public Item(){
        items = new ArrayList<>();
    }

    public Item(String username, String sender, String size, String company, String roomnum,String time){
        this.username = username;
        this.sender = sender;
        this.size = size;
        this.company = company;
        this.roomnum = roomnum;
        this.time = time;
    }

    public void add(Item it){
        items.add(it);
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getRoomnum() {
        return roomnum;
    }

    public void setRoomnum(String roomnum) {
        this.roomnum = roomnum;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public int compareDate(Item o) throws ParseException {
        Date thisDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(time);
        Date oDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(o.time);
        return thisDate.compareTo(oDate);
    }
    public int compareRoom(Item o) {
        if(roomnum.charAt(0)<o.roomnum.charAt(0)){
            return -1;
        }else if(roomnum.charAt(0)==o.roomnum.charAt(0)){
            if(roomnum.charAt(1)<o.roomnum.charAt(1)){
                return -1;
            }else if(roomnum.charAt(1)==o.roomnum.charAt(1)){
                if(roomnum.length()< o.roomnum.length()){
                    return -1;
                }else if(roomnum.length()==4&&o.roomnum.length()==4){
                    return 0;
                }else if(roomnum.length() > o.roomnum.length()){
                    return 1;
                }else {
                    if (roomnum.charAt(2) < o.roomnum.charAt(2)) {
                        return -1;
                    } else if (roomnum.charAt(2) == o.roomnum.charAt(2)) {
                        return 0;
                    } else {
                        return 1;
                    }
                }
            }else{
                return 1;
            }
        }else{

            return 1;
        }
    }
}
