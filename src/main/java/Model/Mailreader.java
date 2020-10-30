package Model;

import Controller.Mail;

import java.util.ArrayList;

public class Mailreader extends Item{
    private ArrayList<Mailreader> userListmail;
    public Mailreader(){userListmail = new ArrayList<>();}
    public Mailreader(String receiver,String sender,String size,String company,String roomNumber,String dateTime){
        super(receiver,sender,size,company,roomNumber,dateTime);
    }
    public void add(Mailreader mr){
        userListmail.add(mr);
    }
    public ArrayList<Mailreader> getUserList() {
        return userListmail;
    }
    public void removeBox(Mailreader mail){
        userListmail.remove(mail);
    }

    @Override
    public String toString() {
        return getRoomnum()+" "+getSender();
    }
    public Mailreader getListByRoomNum(String roomNum){
        String[] room = roomNum.split(" : ");
        Mailreader list = new Mailreader();
        for(Mailreader mail : userListmail){
            if(mail.getRoomnum().equals(room[0])){
                list.add(mail);
            }
        }
        return list;
    }

}
