package Model;

import java.util.ArrayList;

public class CustomerReader {

    private String name;
    private String surname;
    private String username;
    private String password;
    private String floor;
    private String room;
    private String roomnum;
    private String building;

    public CustomerReader(String name, String surname, String room, String floor, String building, String roomnum, String username, String password){
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.floor = floor;
        this.room = room;
        this.building = building;
        this.roomnum = roomnum;

    }

    public String getUsername() {
        return username;
    }

    public String getRoom() {
        return room;
    }

    public String getSurname() {
        return surname;
    }

    public String getFloor() {
        return floor;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getBuilding() {
        return building;
    }

    public String getRoomnum() {
        return roomnum;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoomnum(String roomnum) {
        this.roomnum = roomnum;
    }

}


