package com.deepz.test;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * created by zhangdingping on 2020/2/17
 */
public class HeapTest {

    static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();

        Condition A = lock.newCondition();
        Condition B = lock.newCondition();
        Condition C = lock.newCondition();


        Thread threadA = new Thread(() -> {
            try {
                lock.lock();
                for (int i = 0; i < 10; i++) {
                    while (count % 3 != 0) A.await();
                    System.out.print("A");
                    count++;
                    B.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                lock.lock();
                for (int i = 0; i < 10; i++) {
                    while (count % 3 != 1) B.await();
                    System.out.print("B");
                    count++;
                    C.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        Thread threadC = new Thread(() -> {
            try {
                lock.lock();
                for (int i = 0; i < 10; i++) {
                    while (count % 3 != 2) C.await();
                    System.out.print("C");
                    count++;
                    A.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
    }
}
