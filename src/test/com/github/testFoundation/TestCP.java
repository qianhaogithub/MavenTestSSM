package com.github.testFoundation;

/**
 * @author qianhao
 * @create 2020/4/16-13:22
 */
public class TestCP {

    private static int num = 0;
    private static boolean ready = false;

    public static class ReadThread extends Thread {
        public void run() {
            if (ready) {//(1)
                System.out.println(num + num);//(2)
                    /*如代码由于(1)(2)(3)(4) 之间不存在依赖，所以写线程(3)(4)可能被重排序为先执行（4）在执行（3),那么
                      执行（4）后，读线程可能已经执行了（1）操作，并且在（3）执行前开始执行（2）操作，这时候打印
                      结果为0而不是4.
                      改变程序执行结果的直接原因是重排序，而根本原因是未正确同步。
                      如果程序是正确同步的，程序的执行将具有顺序一致性。即：正确同步程序的执行结果与顺序一致性内
                      存模型的执行结果相同。
                      注意：这里的同步是广义的同步，包括同步原语（synchronized,volatile,fifinal）的正确使用。
                      从源代码到最终实际执行的指令序列，会分别经历以下三中排序
                      2、数据依赖性
                         如果两个操作访问同一个变量，且这两个操作中有一个为写操作，此时这两个操作之间就存在数据依赖
                         性。数据依赖分为下列3种类型，如下图所示
                    */
            }
            System.out.println("read thread....");
        }
    }

    public static class Writethread extends Thread {
        public void run() {
            num = 2;//(3)
            ready = true;//(4)
            System.out.println("writeThread set over...");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReadThread rt = new ReadThread();
        rt.start();

        Writethread wt = new Writethread();
        wt.start();

        Thread.sleep(10);
        rt.interrupt();
        System.out.println("main exit");
    }
}