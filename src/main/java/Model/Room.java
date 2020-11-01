package Model;

import java.util.ArrayList;

public class Room {
    private String building;
    private String type;
    private String floor;
    private String room;
    private String roomnum;
    private int maxarrival;
    private int nowarrival;

    private ArrayList<Room> userList1;

    public Room(){
        userList1 = new ArrayList<Room>();
    }

    public Room(String building, String type, String floor, String room, String roomnum, int maxarrival, int nowarrival){
        this.building = building;
        this.type = type;
        this.floor = floor;
        this.room = room;
        this.roomnum = building + floor + room;
        this.maxarrival = maxarrival;
        this.nowarrival = nowarrival;
    }
    public void add(Room room){

        userList1.add(room);
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public  ArrayList<Room> getUserList() {
        return userList1;
    }

    public int getMaxarrival() {
        return maxarrival;
    }

    public void setMaxarrival(int maxarrival) {
        this.maxarrival = maxarrival;
    }

    public int getNowarrival() {
        return nowarrival;
    }

    public String getRoomnum() {
        return roomnum;
    }

    public void setRoomnum(String roomnum) {
        this.roomnum = roomnum;
    }

    public void setNowarrival(int nowarrival) {
        this.nowarrival = nowarrival;
    }

    public boolean checkAddRoom(String roomNumber){
        for(Room room : userList1){
            if(room.getRoomnum().equals(roomNumber)){
                return true;
            }
        }return false;
    }

    public void setMaxRoom(String roomNumber){
        for(Room room : userList1){
            if(room.getRoomnum().equals(roomNumber)){
                room.setNowarrival(room.getNowarrival() - 1);
            }
        }
    }

    public void setRemoveRoom(String roomNumber){
        for(Room room : userList1){
            if(room.getRoomnum().equals(roomNumber)){
                room.setNowarrival(room.getNowarrival() + 1);
            }
        }
    }
}
