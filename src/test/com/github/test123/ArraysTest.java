package com.github.test123;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author qianhao
 * @create 2020/4/14-23:22
 */
public class ArraysTest {

    @Test
    public void test123() {
        Integer[] ia = {11,2,3,41,4,6,7,3};
        List<Integer> list = Arrays.asList(ia);
        System.out.println(Arrays.toString(ia));
        Arrays.sort(ia);
        System.out.println(Arrays.toString(ia));
        System.out.println(111);
    }
}
