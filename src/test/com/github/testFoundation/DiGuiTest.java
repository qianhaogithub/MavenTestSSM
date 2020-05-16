package com.github.testFoundation;

import org.junit.Test;

/**
 * @author qianhao
 * @create 2020/5/3-8:37
 */
public class DiGuiTest {

    @Test
    public void testDigui1() {
        System.out.println("递归:" + getReturnOfFibonacciSeries(70));
        //System.out.println("For循环结果:" + getReturnOfFibonacciSeries1(70));
    }

    /**
     * for循环求斐波那契数列(不死神兔)
     *
     * @return
     */
    public int getReturnOfFibonacciSeries1(int a) {
        if(a <= 0) {
            throw new RuntimeException("不合法的参数:" + a);
        }
        if (a == 1 || a == 2) {
            return 1;
        }
        int result = 0;
        int num1 = 1;
        int num2 = 1;
        for (int i = 3; i <= a; i++) {
            result = num1 + num2;
            num1 = num2;
            num2 = result;
        }
        return result;
    }

    /**
     * 1,1,2,3,5,8,13,21,34,55..........
     * 递归求斐波那契数列(不死神兔)
     * @return
     */
    public int getReturnOfFibonacciSeries(int a) {
        if(a <= 0) {
            throw new RuntimeException("不合法的参数:" + a);
        }
        if (a == 1 || a == 2) {
            return 1;
        } else {
            return getReturnOfFibonacciSeries(a - 1) + getReturnOfFibonacciSeries(a - 2);
        }
    }

    @Test
    public void testDiGui2() {

    }
}
