package Model;

import java.util.ArrayList;

public class Mailreader {
    private String username;
    private String size;
    private String company;

    private String room;
    private String building;
    private String floor;
    private String roomnum;
    private String time;

    private String sender;

    private ArrayList<Mailreader> userListmail;

    public Mailreader(){
        userListmail = new ArrayList<Mailreader>();
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public Mailreader(String username, String sender, String size, String company,  String roomnum,String time){
        this.username = username;
        this.sender = sender;
        this.size = size;
        this.company = company;

        this.building = building;
        this.room = room;
        this.floor = floor;
        this.roomnum = roomnum;
        this.time = time;

    }
    public void add(Mailreader mail){
        userListmail.add(mail);
    }
    //public boolean checkPassword(String username,String password){
    //    for(Model.Boxreader acc:userListbox){
    //        if(acc.getUsername().equals(username) && acc.getPassword().equals(password)){
    //            return true;
    //       }
    //   }
    //   return false;
    //}

    public String getUsername() {
        return username;
    }

    public String getSender(){return sender;}



    public String getSize() {
        return size;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getCompany() {
        return company;
    }





    public ArrayList<Mailreader> getUserList() {
        return userListmail;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setSender(String sender){
        this.sender = sender;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setCompany(String company) {
        this.company = company;
    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRoomnum() {
        return roomnum;
    }


    public void setRoomnum(String roomnum) {
        this.roomnum = roomnum;
    }





    public void setUserListmail(ArrayList<Mailreader> userListmail) {
        this.userListmail = userListmail;
    }
    public void removeBox(Mailreader mail){
        userListmail.remove(mail);
    }

}
