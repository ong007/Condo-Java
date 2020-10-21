package Model;

import java.util.ArrayList;

public class Roomreader {
    private String building;
    private String type;
    private String floor;
    private String room;


    private ArrayList<Roomreader> userList1;

    public Roomreader(){
        userList1 = new ArrayList<Roomreader>();
    }
    public Roomreader(String building, String type, String floor, String room){
        this.building = building;
        this.type = type;
        this.floor = floor;
        this.room = room;
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

    public ArrayList<Roomreader> getUserList() {
        return userList1;
    }
}
