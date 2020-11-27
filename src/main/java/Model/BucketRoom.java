package Model;

import java.util.ArrayList;

public class BucketRoom {
    ArrayList<Room> bucketRoom;
    private Object CentralOfficer;

    public BucketRoom(){
        bucketRoom = new ArrayList<>();
    }
    public ArrayList<Room> getBucketRoom() {return bucketRoom;}

    public void add(Room room){
        bucketRoom.add(room);
    }

    public boolean checkAddRoom(String roomNumber){
        for(Room room :  bucketRoom){
            if(room.getRoomnum().equals(roomNumber)){
                return true;
            }
        }return false;
    }

    public void setMaxRoom(String roomNumber){
        for(Room room :  bucketRoom){
            if(room.getRoomnum().equals(roomNumber)){
                room.setNowarrival(room.getNowarrival() - 1);
            }
        }
    }

    public void setRemoveRoom(String roomNumber){
        for(Room room :  bucketRoom){
            if(room.getRoomnum().equals(roomNumber)){
                room.setNowarrival(room.getNowarrival() + 1);
            }
        }
    }
}
