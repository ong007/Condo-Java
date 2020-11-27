package Model;

import java.util.ArrayList;

public class Mail extends Item{

    public Mail(String receiver, String sender, String size, String company, String roomNumber, String dateTime){
        super(receiver,sender,size,company,roomNumber,dateTime);
    }

    @Override
    public String toString() {
        return getRoomnum()+" "+getSender();
    }

}
