public class Box extends Mail{
    private int tracking;

    public Box(String from, String recipient, String type, int room, int floor, int time,int tracking) {
        super(from, recipient, type, room, floor, time);
        this.tracking = tracking;
    }
}
