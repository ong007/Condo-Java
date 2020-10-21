package Model;

import java.util.ArrayList;

public class Boxreader {


        private String username;
        private String size;
        private String company;
        private String level;
        private String floor;
        private String room;
        private String hour;
        private String minute;
        private String tracking;
        private String sender;

        private ArrayList<Boxreader> userListbox;

        public Boxreader(){
            userListbox = new ArrayList<>();
        }
        public Boxreader(String username,String sender, String size, String company, String level, String floor, String room,String hour,String minute,String tracking){
            this.username = username;
            this.sender = sender;
            this.size = size;
            this.company = company;
            this.level = level;
            this.floor = floor;
            this.room = room;
            this.hour = hour;
            this.minute = minute;
            this.tracking = tracking;

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

        public String getRoom() {
            return room;
        }

        public String getSize() {
            return size;
        }

        public String getFloor() {
            return floor;
        }

        public String getCompany() {
            return company;
        }

        public String getLevel() {
            return level;
        }
        public String getHour(){
            return hour;
        }
        public String getMinute(){
            return minute;
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

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }

    public void setTracking(String tracking) {
        this.tracking = tracking;
    }

    public void setUserListbox(ArrayList<Boxreader> userListbox) {
        this.userListbox = userListbox;
    }
}
