package com.deepz.test.sync;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * created by zhangdingping on 2020/2/26
 */
public class TwinsLockTest {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition A = lock.newCondition();
        Condition B = lock.newCondition();
        Condition C = lock.newCondition();

        AtomicInteger count = new AtomicInteger(1);

        new Thread(() -> {
            try {
                lock.lock();
                while (true) {
                    while (count.get() % 3 != 1) {
                        A.await(5, TimeUnit.SECONDS);
                        break;
                    }
                    if (count.get() > 30) {
                        break;
                    }
                    System.out.print("A");
                    count.getAndIncrement();
                    B.signalAll();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }).start();

        new Thread(() -> {
            try {
                lock.lock();
                while (true) {
                    while (count.get() % 3 != 2) {
                        B.await(5, TimeUnit.SECONDS);
                        break;
                    }
                    if (count.get() > 30) {
                        break;
                    }
                    System.out.print("B");
                    count.getAndIncrement();
                    C.signalAll();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            try {
                lock.lock();
                while (true) {
                    while (count.get() % 3 != 0) {
                        C.await(5, TimeUnit.SECONDS);
                        break;
                    }
                    if (count.get() > 30) {
                        break;
                    }
                    System.out.print("C");
                    count.getAndIncrement();
                    A.signalAll();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();

    }

}
