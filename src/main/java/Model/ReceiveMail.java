package Model;

import java.util.ArrayList;

public class ReceiveMail {
    private String sender;
    private String username;
    private String company;
    private String roomnum;
    private String size;
    private String time;
    private String nameofficer;

    public ReceiveMail(String sender, String username, String company, String roomnum, String size, String time, String nameofficer){
        this.sender = sender;
        this.username = username;
        this.company = company;
        this.roomnum = roomnum;
        this.size = size;
        this.time = time;
        this.nameofficer = nameofficer;
    }

    public ReceiveMail(){
        userListMail = new ArrayList<>();
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getRoomnum() {
        return roomnum;
    }

    public void setRoomnum(String roomnum) {
        this.roomnum = roomnum;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNameofficer() {
        return nameofficer;
    }

    public void setNameofficer(String nameofficer) {
        this.nameofficer = nameofficer;
    }

    private ArrayList<ReceiveMail> userListMail;

    public ArrayList<ReceiveMail> getUserList1() {
        return userListMail;
    }

    public void setUserList1(ArrayList<ReceiveMail> userList1) {
        this.userListMail = userList1;
    }

    public void add(ReceiveMail box){
        userListMail.add(box);
    }

    public ReceiveMail getListByRoomNum(String roomNum) {
        String[] room = roomNum.split(" : ");
        ReceiveMail receiveMailList = new ReceiveMail();
        for (ReceiveMail mail : userListMail) {
            if (mail.getRoomnum().equals(room[0])) {
                receiveMailList.add(mail);
            }
        }
        return receiveMailList;
    }
}

