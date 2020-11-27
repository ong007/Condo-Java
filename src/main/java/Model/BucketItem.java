package Model;

import java.util.ArrayList;

public class BucketItem {
    ArrayList<Item> bucketItem;
    private Object Item;

    public BucketItem(){
        bucketItem = new ArrayList<>();
    }
    public ArrayList<Item> getBucketItem() {return bucketItem;}
    public void addItem(Item item) {bucketItem.add(item);}

    public BucketItem getListByRoomNum(String roomNum){
        String[] room = roomNum.split(" : ");
        BucketItem itemList = new BucketItem();
        for(Item item : bucketItem){
            if(item.getRoomnum().equals(room[0])){
                itemList.addItem(item);
            }
        }
        return itemList;
    }

    public void removeItem(Item item){
        getBucketItem().remove(item);
    }

}
