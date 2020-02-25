package com.deepz.test;

/**
 * created by zhangdingping on 2020/2/25
 */
public final class Singleton {

    private volatile static Singleton singleton = null;
    
    private Singleton() {
    }

    public static Singleton getInstance() {
        if (null == singleton) {
            synchronized (Singleton.class) {
                if (null == singleton) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
