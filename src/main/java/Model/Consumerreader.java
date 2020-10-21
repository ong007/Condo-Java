package Model;

import java.util.ArrayList;

public class Consumerreader {

    private String name;
    private String surname;
    private String username;
    private String password;
    private String floor;
    private String room;

    private ArrayList<Consumerreader> userList1;

    public Consumerreader(){
        userList1 = new ArrayList<>();
    }
    public Consumerreader(String name, String surname, String room, String floor, String username, String password){
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.floor = floor;
        this.room = room;

    }
    public void add(Consumerreader consumer){

        userList1.add(consumer);
    }
    //public boolean checkPassword(String username,String password){
    //    for(Model.Consumerreader acc:userList1){
    //        if(acc.getUsername().equals(username) && acc.getPassword().equals(password)){
    //            return true;
     //       }
     //   }
     //   return false;
    //}

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

    public ArrayList<Consumerreader> getUserList() {
        return userList1;
    }
}


