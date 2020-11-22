package com.jbrsm.service;

import java.util.concurrent.Callable;

/**
 * @author Adminstrator
 * @description: 多线程学习
 * @date 2020/11/21 11:06
 */
public class ThreadTest {
    private static Object lock = new Object();
    /**
     * @description
     * @param arge
     * @return {@link }
     * @throws
     * @author Adminstrator
     * @date 2020/11/21 11:09
     */
    public static void main(String arge []) throws Exception {
        runA a = new runA("a");
        runA b = new runA("b");
        runA c = new runA("c");
        runA d = new runA("d");
        runA e = new runA("e");
        a.start();
        synchronized (a){
         a.wait();
        }

        b.start();
        b.wait();

        c.start();
        c.wait();

        d.start();
        d.wait();

        e.start();
        e.wait();
    }

    static class runA extends Thread{
        private String index;

        public runA(String index) {
            this.index = index;
        }

        @Override
        public void run() {
            super.run();
            System.out.println(index + " :start");
            /*synchronized (lock){
                System.out.println(Thread.currentThread().getName());
                try {
                    System.out.println(index + " :start");
                    //Thread.sleep(100000L);
                    lock.wait();
                    System.out.println(index + " :end");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }*/
        }
    }

    static class runB implements Runnable{

        @Override
        public void run() {

        }
    }

    static class rnuC implements Callable<String>{

        @Override
        public String call() throws Exception {
            return "6666666";
        }
    }
}
