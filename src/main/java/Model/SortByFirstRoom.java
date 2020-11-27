package Model;

import java.text.ParseException;

public class SortByFirstRoom implements Sortby{
    @Override
    public void sort(BucketItem itemlist) throws ParseException {
        for(int i = 0;i<itemlist.getBucketItem().size();i++) {
            int minPos = i;
            for (int j = i + 1; j < itemlist.getBucketItem().size(); j++) {
                if(itemlist.getBucketItem().get(j).compareRoom(itemlist.getBucketItem().get(minPos))==-1){
                    minPos = j;
                }
            }
            Item sortMail = itemlist.getBucketItem().get(i);
            itemlist.getBucketItem().set(i,itemlist.getBucketItem().get(minPos));
            itemlist.getBucketItem().set(minPos,sortMail);
        }
    }
}
