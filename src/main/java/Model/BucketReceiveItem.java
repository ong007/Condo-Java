package Model;

import java.util.ArrayList;

public class BucketReceiveItem {
    ArrayList<ReceiveMail> bucketReceiveItem;
    public BucketReceiveItem(){
        bucketReceiveItem = new ArrayList<>();
    }
    public ArrayList<ReceiveMail> getBucketReceiveItem() {return bucketReceiveItem;}
    public void addItem(ReceiveMail item) {bucketReceiveItem.add(item);}

    public BucketReceiveItem getListByRoomNum(String roomNum) {
        String[] room = roomNum.split(" : ");
        BucketReceiveItem receiveItemList = new BucketReceiveItem();
        for (ReceiveMail item : bucketReceiveItem) {
            if (item.getRoomnum().equals(room[0])) {
                receiveItemList.addItem(item);
            }
        }
        return receiveItemList;
    }
}
