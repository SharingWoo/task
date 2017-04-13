package indi.wsn.mytask.maptest;

import java.util.HashMap;

/**
 * Created by SharingWoo on 2017/4/7.
 */
public class MapExecutor3 {
    public static void main(String[] args) {
        long timeBegin = System.currentTimeMillis();
        for (int j = 1; j < (1 << 12); j++) {
        HashMap hashMap = new HashMap(1 << 13);
            for (int i = 1; i < (1 << 12); i++) {
                hashMap.put(i, i);
            }
        }
        long timeEnd = System.currentTimeMillis();

        System.out.println(timeEnd - timeBegin);
    }
}
