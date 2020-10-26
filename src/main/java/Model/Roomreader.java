package Model;

import java.util.ArrayList;

public class Roomreader {
    private String building;
    private String type;
    private String floor;
    private String room;
    private String roomnum;
    private int maxarrival;
    private int nowarrival;


    private ArrayList<Roomreader> userList1;

    public Roomreader(){
        userList1 = new ArrayList<Roomreader>();
    }



    public Roomreader(String building, String type, String floor, String room, String roomnum, int maxarrival, int nowarrival){
        this.building = building;
        this.type = type;
        this.floor = floor;
        this.room = room;
        this.roomnum = building + floor + room;
        this.maxarrival = maxarrival;
        this.nowarrival = nowarrival;
    }
    public void add(Roomreader room){

        userList1.add(room);
    }
    //public boolean checkPassword(String username,String password){
    //    for(Model.Consumerreader acc:userList1){
    //        if(acc.getUsername().equals(username) && acc.getPassword().equals(password)){
    //            return true;
    //       }
    //   }
    //   return false;
    //}


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

    public  ArrayList<Roomreader> getUserList() {
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
        for(Roomreader room : userList1){
            if(room.getRoomnum().equals(roomNumber)){
                return true;
            }
        }return false;
    }

    public void setMaxRoom(String roomNumber){
        for(Roomreader room : userList1){
            if(room.getRoomnum().equals(roomNumber)){
                room.setNowarrival(room.getNowarrival() - 1);
            }
        }
    }

    public void setRemoveRoom(String roomNumber){
        for(Roomreader room : userList1){
            if(room.getRoomnum().equals(roomNumber)){
                room.setNowarrival(room.getNowarrival() + 1);
            }
        }
    }
}
