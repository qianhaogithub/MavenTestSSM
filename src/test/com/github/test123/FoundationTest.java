package com.github.test123;

import com.github.bean.Person;
import org.junit.Test;

import java.util.List;
import java.util.Random;

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
        for (int i = 0; i<length-1;i++){
            for(int j = 0;j<length-1-i;j++){
                if(is[j]>is[j+1]){
                    temp = is[j];
                    is[j] = is[j+1];
                    is[j+1] = temp;
                }
            }
        }
        printIntArray(is);
    }

    private void printIntArray(int[] is){
        String str = "[";
        for (int i=0;i<is.length;i++) {
            str += is[i] + ",";
        }
        System.out.println(str.substring(0,str.length()-1) + "]");
    }
}
