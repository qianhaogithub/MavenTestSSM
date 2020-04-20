package com.github.test123;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @author qianhao
 * @create 2020/4/10-21:21
 */
public class RandomTest {

    @Test
    public  void  test1(){
        Random random = new Random();//无参构造  没有给种子  用的是默认种子  是当前时间得默认值
        System.out.println(System.currentTimeMillis());
        for (int i=0;i<=10;i++){
            /*int num = random.nextInt();
            System.out.println(num);*/
            int num = random.nextInt(100) + 1;
            System.out.println(num);
        }
    }

    @Test
    public  void  test2(){
        /*Random random = new Random(2L);//有参构造  每次得到的数是相同的
        System.out.println(System.currentTimeMillis());
        for (int i=0;i<=10;i++){
            *//*int num = random.nextInt();
            System.out.println(num);*//*
            int num = random.nextInt(100) + 1;
            System.out.println(num);
        }*/
        int[] ia1 = {11,22,33,44,55};
        int[] ia2 = {66,77,88,99,0,1,2,3,4};
        System.out.println(Arrays.toString(ia2));
        System.arraycopy(ia1,0,ia2,2,5);
        System.out.println(Arrays.toString(ia2));
    }

    @Test
    public void testRandom(){
        Random random = new Random();
        for (int i = 0; i<100; i++) {
            System.out.println(random.nextInt(2));
        }
    }
}
