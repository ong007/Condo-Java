public class Text extends Mail {
    private String degree;

    public Text(String from, String recipient, String type, int room, int floor, int time,String degree) {
        super(from, recipient, type, room, floor, time);
        this.degree = degree;
    }
}
