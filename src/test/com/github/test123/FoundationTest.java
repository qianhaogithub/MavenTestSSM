package com.github.test123;

import com.github.bean.Person;
import org.junit.Test;
import sun.nio.cs.ext.ISCII91;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * @author qianhao
 * @create 2020/4/10-21:32
 */
public class FoundationTest {

    /**
     * System:   void  gc(); 运行垃圾回收器
     *            void exid(int status);
     *
     */
    @Test
    public void  testSystemClass(){
        Person p1 = new Person(28,"张三");
        System.out.println(p1);

        p1 = null;
        System.gc();
    }

    @Test
    public void testSystemCurrentMiles(){
        long start = System.currentTimeMillis();
        for (int i=0;i<1000000;i++) {
            System.out.println(i);
        }
        long end = System.currentTimeMillis();
        System.out.println((end-start)/1000.0);
    }

    @Test
    public void testSystemArrayCopy(){
    }

    /**
     * 冒泡排序
     */
    @Test
    public void testMaopaoPaixu(){
        int is[] = {11,22,99,88,44,55,66,77,33};
        int temp = 0;
        int length = is.length;
        printIntArray(is);
        for (int i = 0; i<length-1;i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (is[j] > is[j + 1]) {
                    temp = is[j];
                    is[j] = is[j + 1];
                    is[j + 1] = temp;
                }
            }
        }
     }

    private void printIntArray(int[] is){
        String str = "[";
        for (int i=0;i<is.length;i++) {
            str += is[i] + ",";
        }
        System.out.println(str.substring(0,str.length()-1) + "]");
    }

    public void testMaoPao() {
        int[] ia = {2,3,5,6,4,2,9,2,3,6,5,4,2,3};
        for(int i=0; i<ia.length-1; i++){
            for(int j=0;j<ia.length-1-i;j++) {
                if(ia[j]>ia[j+1]) {

                }
            }
        }
    }

    @Test
    public void testMaoPAO() {
        Integer[] is = {88,55,11,22,33,66,44,77,99};
        System.out.println(is);//地址值
        List<Integer> list = (List<Integer>) Arrays.asList(is);
        System.out.println(list);
        System.out.println(Arrays.toString(is));
        Integer[] is1 = bubblingSort(is);
        System.out.println(Arrays.toString(is));
        System.out.println(Arrays.toString(is1));

        Integer[] is11 = {88,55,11,22,33,66,44,77,99};
        System.out.println(Arrays.toString(selectingSort(is11)));
    }

    /**
     * 冒泡排序
     * @param is
     * @return
     */
    public Integer[] bubblingSort(Integer[] is){
        if(is==null){
            return null;
        }
        int temp = 0;
        for (int i=0; i<is.length-1;i++) {
            for (int j=0;j<is.length-1-i;j++) {
                if(is[j]>is[j+1]){
                    temp = is[j];
                    is[j] = is[j+1];
                    is[j+1] = temp;
                }
            }
        }
        return is;
    }

    public Integer[] selectingSort(Integer[] is){
        if(is==null){
            return null;
        }
        int temp = 0;
        for (int i=0;i<is.length-1;i++) {
            for (int j=i+1; j<is.length;j++) {
                if(is[i]>is[j]){
                    temp = is[i];
                    is[i] = is[j];
                    is[j] = temp;
                }
            }
        }
        return is;
    }

    /**
     *
     */
    @Test
    public void testList01() {
        List<String> list = new ArrayList<String>();
        list.add("aaaaa");
        list.add("bbbbb");
        list.add("ccccc");
        list.add("bbbbb");
        list.add("bbbbb");
        list.add("bbbbb");
        list.add("bbbbb");
        list.add("ccccc");
        list.add("bbbbb");
        list.add("ccccc");
        list.add("ddddd");
        list.add("aaaaa");
        list.add("bbbbb");
        list.add("aaaaa");
        list.add("bbbbb");
        for (int i = 0; i < list.size()-1; i++) {
            for (int j = i+1; j<list.size(); j++) {
                if(list.get(i).equals(list.get(j))){
                    list.remove(j--);
                }
            }
        }
        System.out.println(list);
    }

    @Test
    public void testMap1() {
        Map<String,String> map = new HashMap<>();
        /*map.put("aaa","aaa");
        map.put("bbb","bbb");*/
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry.getKey() + "=====" + entry.getValue());
            System.out.println(entry.toString());
        }

        Set<String> strings = map.keySet();
        for (String string : strings) {
            System.out.println(string + "===" + map.get(string));
        }

    }

}
