package com.deepz.other;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * created by zhangdingping on 2019/9/26
 */
public class ThreadABCABC {

    private static Lock lock = new ReentrantLock();
    private static Condition A = lock.newCondition();
    private static Condition B = lock.newCondition();
    private static Condition C = lock.newCondition();

    private static int count = 0;

    static Runnable threadA = () -> {
        try {
            lock.lock();
            for (int i = 0; i < 10; i++) {
                while (count % 3 != 0) {
                    A.await();
                }
                System.out.print("A");
                count++;
                B.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    };

    static Runnable threadB = () -> {
        try {
            lock.lock();
            for (int i = 0; i < 10; i++) {
                while (count % 3 != 1) {
                    B.await();
                }
                System.out.print("B");
                count++;
                C.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    };

    static Runnable threadC = () -> {
        try {
            lock.lock();
            for (int i = 0; i < 10; i++) {
                while (count % 3 != 2) {
                    C.await();
                }
                System.out.print("C");
                count++;
                A.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    };


    public static void main(String[] args) {
        Thread A = new Thread(threadA);
        Thread B = new Thread(threadB);
        Thread C = new Thread(threadC);

        A.start();
        B.start();
        C.start();
    }
}
