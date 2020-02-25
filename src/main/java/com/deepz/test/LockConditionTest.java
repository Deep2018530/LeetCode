package com.deepz.test;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * created by zhangdingping on 2020/2/25
 */
public class LockConditionTest {

    private LinkedList<String> product = new LinkedList<>();

    private AtomicInteger inventory = new AtomicInteger(0);

    private int maxInventory = 10;

    private Lock consumerLock = new ReentrantLock();
    private Lock productLock = new ReentrantLock();

    private Condition notEmptyCondition = consumerLock.newCondition();
    private Condition notFullCondition = productLock.newCondition();


    public void produce(String e) {
        productLock.lock();

        try {
            while (inventory.get() == maxInventory) {
                notFullCondition.await();
            }

            product.add(e);
            System.out.println("放入一个商品库存，总库存：" + inventory.incrementAndGet());

            if (inventory.get() < maxInventory) {
                notFullCondition.signalAll();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            productLock.unlock();
        }

        if (inventory.get() > 0) {
            try {
                consumerLock.lockInterruptibly();
                notEmptyCondition.signalAll();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            } finally {
                consumerLock.unlock();
            }
        }
    }


    public String consume() {
        String result = null;
        consumerLock.lock();
        try {
            while (inventory.get() == 0) {
                notEmptyCondition.await();
            }

            result = product.removeLast();
            System.out.println("消费一个商品，总库存为:" + inventory.decrementAndGet());

            if (inventory.get() > 0) {
                notEmptyCondition.signalAll();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            consumerLock.unlock();
        }
        if (inventory.get() < maxInventory) {
            try {
                productLock.lockInterruptibly();
                notFullCondition.signalAll();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            } finally {
                productLock.unlock();
            }
        }
        return result;
    }
}
