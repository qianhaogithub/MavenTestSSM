package com.github.test123;

import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.io.File;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author qianhao
 * @create 2020/3/23-18:08
 */
public class Test123 {

    @Test
    public void testAAA() {
        System.out.print(12345);
    }

    /*@Test
    public void testMybaitsGenter() throws Exception{
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        File configFile = new File("mbg.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }*/

    @Test
    public void testRemoveList(){
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("c");
        list.add("d");
        System.out.println();
        Iterator<String> iterator = list.iterator();
        String a = "";
        System.out.println(list);
        /*while (iterator.hasNext()){
            a = iterator.next();
            if(a.equals("c")){
                iterator.remove();
            }
        }*/
        for(int i=list.size()-1;i>=0;i--){
            if(list.get(i).equals("c")){
                list.remove(i);
            }
        }
        System.out.println(list);
        //·····list.stream().distinct().collect(Collectors.toList());
        System.out.println("a" instanceof java.lang.String );
    }

    @Test
    public void testContains(){
        //System.out.println("1,2,3".contains(null));
    }

    @Test
    public void testSwitch(){
        int a = 2;
        int b = 3;
        switch(a){
           /* case 2:
                b++;*/
               // break;
            case 1:
                b++;
            case 3:
                b++;
            default:
                b++;
        }

        System.out.println(b);
    }

    @Test
    public void testString(){
        System.out.println(isSame("aa1aa"));
        System.out.println(isSame2("aa1aa"));
    }

    public boolean isSame2(String str){
        if(str==null && "".equals(str)){
            return false;
        }
        StringBuilder sbl = new StringBuilder(str);
        return sbl.reverse().toString().equals(str);
    }

    public boolean isSame(String str){
        if(str==null && "".equals(str)){
            return false;
        }
        int length = str.length();
        char[] cs = str.toCharArray();
        for(int a=0,b=length-1;a<=b;a++,b--){
            if(cs[a]!=cs[b]){
                return false;
            }
        }
        return true;
    }

    @Test
    public void maopaoPaixu(){
        int[] is1 = {1,9,8,7,66,55,88,99,77,55,22,66,74};
        arrayToString(is1);
        int temp = 0;
        for(int i=0;i<is1.length-1;i++){
            for(int j=0;j<is1.length-i-1;j++){
                if(is1[j]>is1[j+1]){
                    temp = is1[j];
                    is1[j]=is1[j+1];
                    is1[j+1]=temp;
                }
            }
        }
        arrayToString(is1);
    }

    public void arrayToString(int[] is){
        String s = "[";
        for (int i=0;i<is.length;i++) {
            s += is[i] + ",";
        }
        s = s + "]";
        System.out.println(s);
    }

    /**
     * 选择排序
     */
    @Test
    public void testSelectedSort(){
        int[] ia = {88,22,33,11,66,77,44,99,55};
        int temp = 0;
        int length = ia.length;
        arrayToString(ia);
        for(int i = 0;i<length-1;i++){
            for(int j = i+1;j<length;j++){
                if(ia[i]>ia[j]){
                    temp = ia[i];
                    ia[i] = ia[j];
                    ia[j] = temp;
                }
            }
        }
        arrayToString(ia);
    }


    @Test
    public void sortingString(){
        String s = "SDAHFhsagHHKASGFY";
        char[] cs = s.toCharArray();
        for (int i = 0;i<cs.length;i++){
            for (int j=0;j<cs.length-1-i;j++){
                if(cs[j]>cs[j+1]){
                    char temp = cs[j];
                    cs[j] = cs[j+1];
                    cs[j+1] = temp;
                }
            }
        }
        System.out.println(String.valueOf(cs));
    }

    @Test
    public void testecz(){
        System.out.println(testErFenChaZhao(55));
    }

    public int testErFenChaZhao(int a){
        Integer ia[] = {88,22,33,11,66,77,44,99,55};

        ia = bubbledSort(ia);

        int leftIndex = 0;
        int rightIndex = ia.length - 1;

        int mid = (leftIndex + rightIndex) / 2;
        while(ia[mid] != a){
            if(ia[mid] > a){
                rightIndex = mid - 1;
            } else {
                leftIndex = mid + 1;
            }
            if(leftIndex>rightIndex){
                return -1;
            }
            mid = (leftIndex + rightIndex) / 2;
        }
        return mid;
    }


    public Integer[] bubbledSort(Integer[] ia){

        if(ia == null){
            return null;
        }else{
            int length = ia.length;
            int temp = 0;
            for(int i = 0; i<ia.length-1; i++){
                for(int j = 0;j<ia.length-1-i;j++){
                    if(ia[j]>ia[j+1]){
                        temp = ia[j];
                        ia[j] = ia[j+1];
                        ia[j+1] = temp;
                    }
                }
            }
        }
        return ia;
    }

    @Test
    public void testValue(){
        Integer i1 = Integer.valueOf("123");
        String str = "1123";
        System.out.println("123");
    }

    @Test
    public void testList(){
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        list.add("ccc");
        list.add("ccc");
        list.add("ccc");
        list.add("aaa");
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("aaa");
        list.add("eee");
        for(int i=0;i<list.size()-1;i++){
            for (int j=i+1;j<list.size();j++){
                if(list.get(i).equals(list.get(j))){
                    list.remove(j--);
                }
            }
        }
        list.forEach((value)->{
            System.out.println(value);
        });
        System.out.println(list);
    }

    @Test
    public void testTreeSet(){
        TreeSet<Integer> ts = new TreeSet<Integer>();
        ts.add(111);
        ts.add(222);
        ts.add(111);
        ts.add(999);
        ts.add(888);
        ts.add(333);
        System.out.println(ts);
    }

    @Test
    public void test(){
        Test123 t = new Test123();
        MathOperation addition = (int a, int b) -> {
            System.out.println(a + "====" +b);
        };
        addition.operation(1,2);
    }

    interface MathOperation {
        void operation(int a, int b);
    }
    @Test
    public void test1() {
        Object s = (String)null;
        Map<String,String> map = new HashMap<String,String>();
        map.put("aaa","aaa");
        map.put("bbb","bbb");
        map.put("ccc","ccc");

        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry.getKey() + "===" + entry.getValue());
        }
        System.out.println("===========JDK8:Map集合新遍历方式加上Lamda表达式的使用");
        map.forEach((key,value)->{
            System.out.println(key + "===" + value);
        });
    }
}
