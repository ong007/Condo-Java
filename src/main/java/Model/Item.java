package Model;

import java.util.ArrayList;

public class Item {
    private String username;
    private String size;
    private String company;
    private String room;
    private String building;
    private String floor;
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
//        this.building = building;
//        this.room = room;
//        this.floor = floor;
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

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
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
}
