public class Mail {
    private String from;
    private String recipient;
    private String type;
    private int room,floor;
    private int time;

    public Mail(String from, String recipient, String type, int room, int floor, int time){
        this.from = from;
        this.recipient = recipient;
        this.type = type;
        this.room = room;
        this.floor = floor;
        this.time = time;
    }

    public String getFrom(){
        return from;
    }
    public String getRecipient(){
        return recipient;
    }
    public String getType(){
        return type;
    }
    public int getRoom(){
        return room;
    }
    public int getFloor(){
        return floor;
    }
    public int getTime(){
        return time;
    }
}
