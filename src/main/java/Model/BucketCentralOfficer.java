package Model;

import java.util.ArrayList;

public class BucketCentralOfficer {
    ArrayList<CentralOfficer> bucketCentralOfficer;
    ArrayList<CustomerReader> bucketCustomer;
    private Object CentralOfficer;

    public BucketCentralOfficer(){
        bucketCentralOfficer = new ArrayList<>();
    }
    public ArrayList<CentralOfficer> getBucketCentralOfficer() {return bucketCentralOfficer;}
    public ArrayList<CustomerReader> getBucketCustomer() {return bucketCustomer;}

    public boolean checkStatus(String username){
        for (CentralOfficer acc:bucketCentralOfficer) {
            if (acc.getUsername().equals(username)){
                if (acc.getStatus().equals("Banned")){
                    return false;
                }
            }
        }return true;
    }

    public void add(CentralOfficer central){
        bucketCentralOfficer.add(central);
    }

    public boolean checkPassword(String username,String password){
        for(CentralOfficer acc:bucketCentralOfficer){
            if(acc.getUsername().equals(username) && acc.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    public void changePassword(String username,String password,String newPassword){
        for(CentralOfficer acc:bucketCentralOfficer){
            if (acc.getUsername().equals(username) && acc.getPassword().equals(password)){
                acc.setPassword(newPassword);
            }
        }
    }
    public boolean checkUser(String username, BucketCustomer consumer){
        if (username.equals(new SetPasswordAdmin().getUser())){
            return  false;
        }
        for(CustomerReader acc : consumer.getBucketCustomer()){
            if (acc.getUsername().equals(username))
                return false;
        }
        for(CentralOfficer acc : bucketCentralOfficer){
            if (acc.getUsername().equals(username))
                return false;
        }
        return true;
    }

    public CentralOfficer getAcc(String username){
        for(CentralOfficer acc:bucketCentralOfficer){
            if(acc.getUsername().equals(username)){
                return acc;
            }
        }
        return null;
    }



}
