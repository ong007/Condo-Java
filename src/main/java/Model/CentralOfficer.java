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

}
