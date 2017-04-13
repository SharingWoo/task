package indi.wsn.mytask.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by SharingWoo on 2017/4/11.
 */
public class CollectionsTest {

    public static void main(String args[]) {
        List<String> list=new ArrayList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()) {
                if("C".equals(iterator.next())){
                    list.remove("C");
                }
        }
    }
}
