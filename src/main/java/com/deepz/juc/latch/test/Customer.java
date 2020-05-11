package com.deepz.juc.latch.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * created by zhangdingping on 2020/5/11
 */
public class Customer implements Runnable {

    private CountDownLatch latch;
    private String name;

    public Customer(CountDownLatch latch, String name) {
        this.latch = latch;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
            Random random = new Random();

            System.out.println(sdf.format(new Date()) + " " + name + "出发去饭店");
            Thread.sleep((long) (random.nextDouble() * 3000) + 1000);
            System.out.println(sdf.format(new Date()) + " " + name + "到了饭店");
            latch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
