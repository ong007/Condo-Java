package Model;

import java.util.ArrayList;

public class CentralOfficer {
    private String name;
    private String surname;
    private String username;
    private String password;
    private String tel;
    private String email;
    private String time;
    private String status;
    private int attempt;


    private ArrayList<CentralOfficer> userList;

    public CentralOfficer(){
        userList = new ArrayList<>();
    }
    public CentralOfficer(String name, String surname, String tel, String email, String username, String password, String time, String status, int attempt){
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
    public void setPassword(String password) {
        this.password = password;
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

    public ArrayList<CentralOfficer> getUserList() {
        return userList;
    }

    public boolean checkStatus(String username){

        for (CentralOfficer acc:userList) {
            if (acc.getUsername().equals(username)){
                if (acc.getStatus().equals("Banned")){
                    return false;
                }
            }
        }return true;
    }

    public void add(CentralOfficer central){
        userList.add(central);
    }

    public boolean checkPassword(String username,String password){
        for(CentralOfficer acc:userList){
            if(acc.getUsername().equals(username) && acc.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    public void changePassword(String username,String password,String newPassword){
        for(CentralOfficer acc:userList){
            if (acc.getUsername().equals(username) && acc.getPassword().equals(password)){
                acc.setPassword(newPassword);
            }
        }
    }

    public boolean checkUser(String username, CustomerReader consumer){
        if (username.equals(new SetPasswordAdmin().getUser())){
            return  false;
        }
        for(CustomerReader acc : consumer.getUserList()){
            if (acc.getUsername().equals(username))
                return false;
        }
        for(CentralOfficer acc : userList){
            if (acc.getUsername().equals(username))
                return false;
        }
        return true;
    }

    public CentralOfficer getAcc(String username){
        for(CentralOfficer acc:userList){
            if(acc.getUsername().equals(username)){
                return acc;
            }
        }
        return null;
    }
}
