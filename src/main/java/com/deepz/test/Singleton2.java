package com.deepz.test;

/**
 * created by zhangdingping on 2020/2/25
 */
public final class Singleton2 {


    public static class InnerSingleton {
        private static Singleton2 singleton2 = new Singleton2();
    }

    public Singleton2 getInstance() {
        return InnerSingleton.singleton2;
    }
}
