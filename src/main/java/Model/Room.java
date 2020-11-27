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


    public Room(String building, String type, String floor, String room, String roomnum, int maxarrival, int nowarrival){
        this.building = building;
        this.type = type;
        this.floor = floor;
        this.room = room;
        this.roomnum = building + floor + room;
        this.maxarrival = maxarrival;
        this.nowarrival = nowarrival;
    }

    public String getBuilding() {
        return building;
    }

    public String getType() {
        return type;
    }

    public String getFloor() {
        return floor;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public int getMaxarrival() {
        return maxarrival;
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


}
