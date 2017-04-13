package indi.wsn.mytask.maptest;

import indi.wsn.mytask.pojo.PojoTest;

import java.io.Serializable;

/**
 * Created by SharingWoo on 2017/4/7.
 */
public class Test {
    public static void main(String[] args) {
        PojoTest test = new PojoTest();
        contains(test);
    }
    public static<T>  void contains(T t) {
        System.out.println( t instanceof Serializable);
    }
}
