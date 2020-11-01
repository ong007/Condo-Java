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



    private ArrayList<CustomerReader> userList1;

    public CustomerReader(){
        userList1 = new ArrayList<>();
    }

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

    public void setBuilding(String building) {
        this.building = building;
    }

    public ArrayList<CustomerReader> getUserList() {
        return userList1;
    }

    public void removeConsumer(CustomerReader consumer){
        userList1.remove(consumer);
    }

    public boolean checkUser(String username, CentralOfficer central){
        if (username.equals(new SetPasswordAdmin().getUser())){
            return  false;
        }
        for(CentralOfficer acc : central.getUserList()){
            if (acc.getUsername().equals(username))
                return false;
        }
        for(CustomerReader acc : userList1){
            if (acc.getUsername().equals(username))
                return false;
        }
        return true;
    }


    public boolean checkReceived(String username, String password){
        for(CustomerReader acc : userList1){
            if(acc.getUsername().equals(username) && acc.getPassword().equals(password)){
                return true;
            }
        }return false;
    }

    public void changePassword(String username,String password,String newPassword){
        for(CustomerReader acc:userList1){
            if (acc.getUsername().equals(username) && acc.getPassword().equals(password)){
                acc.setPassword(newPassword);
            }
        }
    }

    public CustomerReader getAcc(String username){
        for(CustomerReader acc:userList1){
            if(acc.getUsername().equals(username)){
                return acc;
            }
        }
        return null;
    }

    public void add(CustomerReader consumer){
        userList1.add(consumer);
    }
}


