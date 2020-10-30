package Model;

import java.util.ArrayList;

public class Consumerreader {

    private String name;
    private String surname;
    private String username;
    private String password;
    private String floor;
    private String room;
    private String roomnum;
    private String building;



    private ArrayList<Consumerreader> userList1;

    public Consumerreader(){
        userList1 = new ArrayList<>();
    }

    public Consumerreader(String name, String surname, String room, String floor, String building,String roomnum, String username, String password){
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

    public void setBuilding(String building) {
        this.building = building;
    }

    public ArrayList<Consumerreader> getUserList() {
        return userList1;
    }

    public void removeConsumer(Consumerreader consumer){
        userList1.remove(consumer);
    }

    public boolean checkUser(String username,Centraluserreader central){
        if (username.equals(new setpasswordA().getUser())){
            return  false;
        }
        for(Centraluserreader acc : central.getUserList()){
            if (acc.getUsername().equals(username))
                return false;
        }
        for(Consumerreader acc : userList1){
            if (acc.getUsername().equals(username))
                return false;
        }
        return true;
    }


    public boolean checkReceived(String username, String password){
        for(Consumerreader acc : userList1){
            if(acc.getUsername().equals(username) && acc.getPassword().equals(password)){
                return true;
            }
        }return false;
    }

    public void changePassword(String username,String password,String newPassword){
        for(Consumerreader acc:userList1){
            if (acc.getUsername().equals(username) && acc.getPassword().equals(password)){
                acc.setPassword(newPassword);
            }
        }
    }

    public Consumerreader getAcc(String username){
        for(Consumerreader acc:userList1){
            if(acc.getUsername().equals(username)){
                return acc;
            }
        }
        return null;
    }

    public void add(Consumerreader consumer){
        userList1.add(consumer);
    }
}


