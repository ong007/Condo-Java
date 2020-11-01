package Model;

import java.util.ArrayList;

public class Mail extends Item{
    private ArrayList<Mail> userListmail;
    public Mail(){userListmail = new ArrayList<>();}
    public Mail(String receiver, String sender, String size, String company, String roomNumber, String dateTime){
        super(receiver,sender,size,company,roomNumber,dateTime);
    }
    public void add(Mail mr){
        userListmail.add(mr);
    }
    public ArrayList<Mail> getUserList() {
        return userListmail;
    }
    public void removeBox(Mail mail){
        userListmail.remove(mail);
    }

    @Override
    public String toString() {
        return getRoomnum()+" "+getSender();
    }
    public Mail getListByRoomNum(String roomNum){
        String[] room = roomNum.split(" : ");
        Mail list = new Mail();
        for(Mail mail : userListmail){
            if(mail.getRoomnum().equals(room[0])){
                list.add(mail);
            }
        }
        return list;
    }

}
