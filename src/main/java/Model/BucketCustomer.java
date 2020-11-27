package Model;

import java.util.ArrayList;

public class BucketCustomer {
    ArrayList<CustomerReader> bucketCustomer;
    ArrayList<CentralOfficer> bucketCentralOfficer;
    private Object CentralOfficer;

    public BucketCustomer(){
        bucketCustomer = new ArrayList<>();
    }
    public ArrayList<CustomerReader> getBucketCustomer() {return bucketCustomer;}
    public ArrayList<CentralOfficer> getBucketCentralOfficer() {return bucketCentralOfficer;}

    public void removeConsumer(CustomerReader consumer){
        bucketCustomer.remove(consumer);
    }

    public boolean checkUser(String username, BucketCentralOfficer central){

        if (username.equals(new SetPasswordAdmin().getUser())){
            return  false;
        }
        for(CentralOfficer acc : central.getBucketCentralOfficer()){
            if (acc.getUsername().equals(username))
                return false;
        }
        for(CustomerReader acc : bucketCustomer){
            if (acc.getUsername().equals(username))
                return false;
        }
        return true;
    }


    public boolean checkReceived(String username, String password){
        for(CustomerReader acc : bucketCustomer){
            if(acc.getUsername().equals(username) && acc.getPassword().equals(password)){
                return true;
            }
        }return false;
    }

    public void changePassword(String username,String password,String newPassword){
        for(CustomerReader acc:bucketCustomer){
            if (acc.getUsername().equals(username) && acc.getPassword().equals(password)){
                acc.setPassword(newPassword);
            }
        }
    }

    public CustomerReader getAcc(String username){
        for(CustomerReader acc:bucketCustomer){
            if(acc.getUsername().equals(username)){
                return acc;
            }
        }
        return null;
    }

    public void add(CustomerReader consumer){
        bucketCustomer.add(consumer);
    }
}
