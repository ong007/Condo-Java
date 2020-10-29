package Model;

import java.util.ArrayList;

public class ReceiveTextReader {
    private String sender;
    private String username;
    private String company;
    private String roomnum;
    private String level;
    private String size;
    private String time;
    private String nameofficer;

    public ReceiveTextReader(String sender,String username, String company, String roomnum, String level, String size,String time, String nameofficer){
        this.sender = sender;
        this.username = username;
        this.company = company;
        this.roomnum = roomnum;
        this.level = level;
        this.size = size;
        this.time = time;
        this.nameofficer = nameofficer;
    }

    public ReceiveTextReader (){
        userList1 = new ArrayList<>();
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getRoomnum() {
        return roomnum;
    }

    public void setRoomnum(String roomnum) {
        this.roomnum = roomnum;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNameofficer() {
        return nameofficer;
    }

    public void setNameofficer(String nameofficer) {
        this.nameofficer = nameofficer;
    }

    private ArrayList<ReceiveTextReader> userList1;

    public ArrayList<ReceiveTextReader> getUserList1() {
        return userList1;
    }

    public void setUserList1(ArrayList<ReceiveTextReader> userList1) {
        this.userList1 = userList1;
    }

    public void add(ReceiveTextReader box){
        userList1.add(box);
    }
}
