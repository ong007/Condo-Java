package Model;

import java.util.ArrayList;

public class Boxreader {


        private String username;
        private String size;
        private String company;
        private String level;
        private String room;
        private String building;
        private String floor;
        private String roomnum;
        private String time;
        private String tracking;
        private String sender;

        private ArrayList<Boxreader> userListbox;

        public Boxreader(){
            userListbox = new ArrayList<>();
        }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public Boxreader(String username, String sender, String size, String company, String level, String roomnum, String tracking,String time){
            this.username = username;
            this.sender = sender;
            this.size = size;
            this.company = company;
            this.level = level;
            this.roomnum = roomnum;
            this.tracking = tracking;
            this.time = time;
        }
        public void add(Boxreader box){
            userListbox.add(box);
        }
        //public boolean checkPassword(String username,String password){
        //    for(Model.Boxreader acc:userListbox){
        //        if(acc.getUsername().equals(username) && acc.getPassword().equals(password)){
        //            return true;
        //       }
        //   }
        //   return false;
        //}

        public String getUsername() {
            return username;
        }

        public String getSender(){return sender;}



        public String getSize() {
            return size;
        }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getCompany() {
            return company;
        }

        public String getLevel() {
            return level;
        }

        public String getTracking(){
            return tracking;
        }

        public ArrayList<Boxreader> getUserList() {
            return userListbox;
        }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setSender(String sender){
            this.sender = sender;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getRoomnum() {
        return roomnum;
    }


    public void setRoomnum(String roomnum) {
        this.roomnum = roomnum;
    }

    public String getTime() {
            return time;
    }

    public void setTime(String time) {
            this.time = time;
    }

    public void setTracking(String tracking) {
            this.tracking = tracking;
    }

    public void setUserListbox(ArrayList<Boxreader> userListbox) {
            this.userListbox = userListbox;
    }

    public void removeBox(Boxreader box){
            userListbox.remove(box);
    }
}
