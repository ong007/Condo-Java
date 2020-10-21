import java.util.ArrayList;

public class Centraldata {
    private String username;
    private String password;
    private ArrayList<Centraldata> account;
    public Centraldata(){
        account = new ArrayList<>();
    }
    public Centraldata(String username,String password)
    {
        this.username=username;
        this.password=password;
    }
    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    //public boolean check(String username,String password)
    //{
    //   for(Centraldata acc: account)
    //    {
    //        if(acc.getUsername().equals(username) && acc.getPassword().equals(password))
    //           return true;
    //   }
    //    return false;
    //}
}
