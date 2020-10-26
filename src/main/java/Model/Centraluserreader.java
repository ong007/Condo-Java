package Model;

import java.util.ArrayList;

public class Centraluserreader {
    private String name;
    private String surname;
    private String username;
    private String password;
    private String tel;
    private String email;
    private String time;
    private String status;
    private int attempt;


    private ArrayList<Centraluserreader> userList;

    public Centraluserreader(){
        userList = new ArrayList<>();
    }
    public Centraluserreader(String name,String surname,String tel,String email, String username,String password,String time,String status,int attempt){
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.tel = tel;
        this.email = email;
        this.time = time;
        this.status = status;
        this.attempt = attempt;

    }
    public void add(Centraluserreader central){
        userList.add(central);
    }
    public boolean checkPassword(String username,String password){
        for(Centraluserreader acc:userList){
            if(acc.getUsername().equals(username) && acc.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    public boolean checkUser(String username,Consumerreader consumer){
        if (username.equals(new setpasswordA().getUser())){
            return  false;
        }
        for(Consumerreader acc : consumer.getUserList()){
            if (acc.getUsername().equals(username))
                return false;
        }
        for(Centraluserreader acc : userList){
            if (acc.getUsername().equals(username))
                return false;
        }
        return true;
    }

    public Centraluserreader getAcc(String username){
        for(Centraluserreader acc:userList){
            if(acc.getUsername().equals(username)){
                return acc;
            }
        }
        return null;
    }


    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getSurname() {
        return surname;
    }

    public String getTel() {
        return tel;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAttempt() {
        return attempt;
    }

    public void setAttempt(int attempt) {
        this.attempt = attempt;
    }

    public ArrayList<Centraluserreader> getUserList() {
        return userList;
    }

    public boolean checkStatus(String username){

        for (Centraluserreader acc:userList) {
            if (acc.getUsername().equals(username)){
                if (acc.getStatus().equals("Banned")){
                    return false;
                }
            }
        }return true;
    }
}
