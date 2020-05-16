package com.github.testFoundation;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

/**
 * @author qianhao
 * @create 2020/4/22-22:14
 */
public class ListTest {

    @Test
    public void testVector() {
        Vector<String> vector = new Vector<String>();
        vector.addElement("aaa");
        vector.add("111");
        vector.insertElementAt("222",0);
        System.out.println(vector);
    }

    @Test
    public void testArraysList () {
        List<String> list = new ArrayList<String>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ccc");
        list.add("ccc");
        list.add("ddd");
        list.add("bbb");
        list.add("bbb");
        list.add("aaa");
        list.add("aaa");
        list.add("ddd");
        list.add("ddd");
        for (int i=0 ;i<list.size()-1;i++) {
            for (int j=i+1;j<list.size();j++){
                if(list.get(i).equals(list.get(j))){
                    list.remove(j--);
                }
            }
        }
        System.out.println(list);
     }

     @Test
     public void testLinkedList () {
         //LinkedList
     }

     @Test
     public void testMap() {
         Map<String,String> map = new HashMap<String,String>();
         map.put("aaa","aaa");
         map.put("bbb","bbb");
         map.put("ccc","ccc");
         map.forEach((k,v)->{

         });
         Set<Map.Entry<String, String>> entries = map.entrySet();
         for (Map.Entry<String, String> entry : entries) {
             String key = entry.getKey();
             String value = entry.getValue();
             System.out.println(key + "=========" + value);
         }
     }
}
