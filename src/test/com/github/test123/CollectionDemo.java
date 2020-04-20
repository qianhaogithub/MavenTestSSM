package com.github.test123;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author qianhao
 * @create 2020/4/10-23:20
 */
public class CollectionDemo{

    @Test
    public void test11(){
        Collection c = new ArrayList();
        c.add("111");
        c.add("222");
        c.add("333");
        /*Object[] arr = c.toArray();
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i] instanceof String);
        }*/
        Iterator it = c.iterator();
        while (it.hasNext()){
            Object obj = it.next();
            System.out.println(obj);
        }
    }

    @Test
    public void testCollectionCRUD(){
        Collection collection = new ArrayList();
        collection.add("123");
        collection.add("456");
        collection.add("999");
        System.out.println(collection);
        Collection c1 = new ArrayList();
        c1.add("123");
        c1.add("000");
        c1.add("456");
        c1.retainAll(collection);
        System.out.println(c1);
        System.out.println(c1.containsAll(collection));
        /*collection.addAll(c1);
        System.out.println(collection);
        //collection.clear();
        collection.contains("000");
        System.out.println(collection);*/
    }
}
