package indi.wsn.mytask.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 数组工具类
 * Created by SharingWoo on 2017/4/11.
 */
public class Lists {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList(400000);
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (int i = 0; i < 40000; i++) {
            arrayList.add(i);
        }
        LinkedList linkedList = new LinkedList(arrayList);

        long timeBegin = System.currentTimeMillis();
        removeEvensOne(linkedList,1);
        long timeEnd = System.currentTimeMillis();
        System.out.println(timeEnd - timeBegin);
       /* removeEvensOne(linkedList);
        long timeEnd2 = System.currentTimeMillis();
        System.out.println(timeEnd2-timeEnd);*/

    }

    public static void removeEvensOne(List<Integer> list, int way) {
        if (way == 1) {
            for (int i : list) {
                int thisItem = i;
            }
        } else {
            for (int i = 0; i < list.size(); i++) {
                int thisItem = list.get(i);
            }
        }
    }
}