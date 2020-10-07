import java.util.ArrayList;

public class Centraluserreader {
    private ArrayList<Centraldata> userList;

    public Centraluserreader(){
        userList = new ArrayList<>();
    }
    public void add(Centraldata central){
        userList.add(central);
    }

    public ArrayList<Centraldata> getUserList() {
        return userList;
    }
}
