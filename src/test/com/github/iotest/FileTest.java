package com.github.iotest;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.github.bean.Person;
import org.aspectj.weaver.EnumAnnotationValue;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.SequenceInputStream;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Scanner;
import java.util.Vector;

/**
 * @author qianhao
 * @create 2020/4/30-23:58
 */
public class FileTest {

    @Test
    public void testFile1() throws IOException {
        File f = new File("E:\\iofile");
        if (!f.exists()) {
            f.mkdir();//创建文件夹
        }

        File f1 = new File(f, "a.txt");
        if (!f1.exists()) {
            f1.createNewFile();
        }
    }

    @Test
    public void testFile2() {
        File f = new File("F:\\java基础视频\\day19\\avi");
        String[] names = f.list();
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println("===============================================");
        File[] fs = f.listFiles();
        for (File file : fs) {
            System.out.println(file.getAbsolutePath());
        }
    }

    @Test
    public void testFileList() {
        File f = new File("F:\\java基础视频\\day19\\avi");
        String[] fs = f.list((file, name) -> {
            if (new File(file, name).isDirectory()) {
                return false;
            } else {
                if (name.endsWith(".avi")) {
                    return true;
                }
            }
            return false;
        });
        /*for (String s : fs) {
            System.out.println(s);
        }*/
    }

    @Test
    public void testFiles3() {
        File f = new File("F:\\java基础视频\\day01");
        listAllFiles(f);
    }

    public void listAllFiles(File f) {
        if (f == null || !f.exists()) {
            return;
        }
        File[] fs = f.listFiles();
        for (File file : fs) {
            if (file.isFile()) {
                System.out.println(file.getAbsolutePath());
            } else {
                listAllFiles(file);
            }
        }
    }

    @Test
    public void testFile3() {
        File f = new File("a.txt");
        OutputStream os = null;
        InputStream is = null;
        try {
            if (!f.exists()) {
                f.createNewFile();
            }
            os = new FileOutputStream(f);
            os.write("Hello World!!!".getBytes());
            is = new FileInputStream(f);
            byte[] bs = new byte[1024];
            int len = 0;
            String s = "";
            while ((len = is.read(bs)) != -1) {
                s = new String(bs);
            }
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testCopyFile() {
        File f1 = new File("F:\\IO_TEST\\AAA\\AAAAA.avi");
        File f2 = new File("F:\\IO_TEST\\CCC");
        copyFile(f1,f2);
    }
    /**
     * @param srcFile    待复制的源文件(夹)
     * @param targetFile 复制到目标文件夹
     */
    public void copyFile(File srcFile, File targetFile) {
        if (srcFile == null || !srcFile.exists()) {
            throw new RuntimeException("源文件不存在");
        }
        if(targetFile==null) {
            throw new RuntimeException("目标文件夹不能传null");
        }
        if(targetFile.exists() && targetFile.isFile()) {
            throw new RuntimeException("目标文件夹不能定义为已有的文件");
        }
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        File f = new File(targetFile, srcFile.getName());
        if (srcFile.isDirectory()) {
            if (!f.exists()) {
                f.mkdir();
            }
        } else {
            FileInputStream fis = null;
            FileOutputStream fos = null;
            try {
                fis = new FileInputStream(srcFile);
                fos = new FileOutputStream(f);
                byte[] bs = new byte[1024];
                int len = 0;
                while((len=fis.read(bs))!=-1) {
                    fos.write(bs,0,len);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if(fis!=null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if(fos!=null) {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Test
    public void testBufferStream() throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("F:\\IO_TEST\\AAA\\AAAAA.avi"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("F:\\IO_TEST\\CCC\\copy.avi"));
        int len = 0;
        byte[] bs = new byte[1024];
        while ((len=bis.read(bs))!=-1){
            bos.write(bs,0,len);
        }
        bis.close();
        bos.close();
    }

    @Test
    public void testCharStream() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("FileTest.java"));
        int len = 0;
        char[] bs = new char[1024];
        StringBuilder sbl = new StringBuilder();
        while((len=reader.read(bs))>0){
            sbl.append(bs,0,len);
        }
        System.out.println(sbl);
    }

    @Test
    public void testCharStream2() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("FileTest.java"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("aaa.txt"));
        String s = null;
        while ((s=reader.readLine())!=null) {
            writer.write(s);
            writer.newLine();
            writer.flush();
        }
        reader.close();
        writer.close();

    }

    @Test
    public void testZhuanhuanliu() throws IOException {
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("c.txt"),"UTF-8");
        InputStreamReader isw = new InputStreamReader(new FileInputStream("a.txt"),"UTF-8");
        char[] cs = new char[200];
        int len = 0;
        while ((len = isw.read(cs))>0){
            osw.write(cs,0,len);
            osw.flush();
        }
        osw.close();
        isw.close();
    }

    @Test
    public void testMemoryStream() throws IOException {
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        for(int i = 0; i < 10; i++) {
            bao.write("hello world".getBytes());
        }
        byte[] bs = bao.toByteArray();
        System.out.println(new String(bs));
        ByteArrayInputStream bai = new ByteArrayInputStream(bs);
        int len = 0;
        while((len=bai.read())!=-1){
            System.out.print((char)len);
        }

        bao.close();
    }

    @Test
    public void testPrintStream() throws FileNotFoundException {
        PrintWriter pw = new PrintWriter("a2.txt");

        pw.print(true);
        pw.print(100);
        pw.print("hello World!!!");

        pw.close();
    }

    @Test
    public void test1() {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        System.out.println(a);
        int b = sc.nextInt();
        System.out.println(b);
    }

    @Test
    public void testRandomAccessFile() throws IOException {
        RandomAccessFile raf = new RandomAccessFile("a2.txt","rw");

        raf.writeUTF("中国");

        raf.close();
    }

    @Test
    public void testSequanceInputStream() throws IOException {
        InputStream is1 = new FileInputStream("a.txt");
        InputStream is2 = new FileInputStream("a2.txt");
        SequenceInputStream sis = new SequenceInputStream(is1,is2);
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("a3.txt"));
        int len = 0;
        byte[] bs = new byte[1024];
        while ((len=sis.read(bs))>0) {
            bos.write(bs,0,len);
            bos.flush();
        }

        sis.close();
        bos.close();
    }

    @Test
    public void testSequanceInputStream1() throws IOException {
        InputStream is1 = new FileInputStream("a.txt");
        InputStream is2 = new FileInputStream("a2.txt");
        SequenceInputStream sis = new SequenceInputStream(is1,is2);
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("a3.txt"));
        Vector<InputStream> vector = new Vector<>();
        vector.addElement(is1);
        vector.addElement(is2);
        Enumeration<InputStream> e = vector.elements();
        int len = 0;
        byte[] bs = new byte[1024];
        while ((len=sis.read(bs))>0) {
            bos.write(bs,0,len);
            bos.flush();
        }

        sis.close();
        bos.close();
    }

    @Test
    public void testObject() throws IOException, ClassNotFoundException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("a.txt"));

        Person p = new Person();
        p.setAge(24);
        p.setName("QH");
        System.out.println(p);
        oos.writeObject(p);

        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("a.txt"));
        Person p1 = (Person) ois.readObject();
        System.out.println(p1);
    }

    @Test
    public void testProperties() {
        Properties properties = new Properties();

        properties.put("aaa","aaa");
        properties.setProperty("bbb","bbb");

        properties.setProperty("ccc","ccc");
        Object o = properties.setProperty("bbb2","bbb1");
        System.out.println(o);
        properties.forEach((key,value)->{
            System.out.println(key + "===" +value);
        });
    }

    @Test
    public void testProperties2() throws IOException {
        Properties prop = new Properties();
        prop.load(new FileReader("aaa.properties"));

        prop.forEach((key,value)->{
            System.out.println(key + "===" + value);
        });

        Properties prop2 = new Properties();
        prop2.setProperty("AAA","AAA1");
        prop2.setProperty("BBB","BBB1");
        prop2.setProperty("CCC","CCC1");

        Writer w = new BufferedWriter(new FileWriter("a2.properties"));
        prop2.store(w,"大家好啊");
    }
}
