import java.util.ArrayList;

public class Consumerdata {

        private String username;
        private String password;
        private ArrayList<Centraldata> account1;
        public Consumerdata(){
            account1 = new ArrayList<>();
        }
        public Consumerdata(String username,String password)
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
        //    for(Centraldata acc: account1)
        //    {
        //        if(acc.getUsername().equals(username) && acc.getPassword().equals(password))
        //            return true;
        //    }
        //    return false;}
        }


