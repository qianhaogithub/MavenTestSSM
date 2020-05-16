package com.github.iotest;

import org.junit.Test;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author qianhao
 * @create 2020/5/3-21:43
 */
public class NioTest {

    /**
     * JDK1.7 Files的工具类使用
     */
    @Test
    public void testFiles() throws IOException {
      /*  Files.copy(Paths.get("F:\\IO_TEST\\AAA\\AAAAA.avi"),
                new BufferedOutputStream(new FileOutputStream("F:\\IO_TEST\\AAA\\AAAAA1.avi")));*/

        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        Files.write(Paths.get("aaa.txt"),list, Charset.defaultCharset());
    }
}
