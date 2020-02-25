package com.deepz.test;

/**
 * created by zhangdingping on 2020/2/26
 */
public class ABC {

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            Thread A = new Thread(() -> System.out.print("A"));
            Thread B = new Thread(() -> System.out.print("B"));
            Thread C = new Thread(() -> System.out.print("C"));

            A.start();
            B.start();
            C.start();
            A.join();
            B.join();
            C.join();
        }
    }
}
