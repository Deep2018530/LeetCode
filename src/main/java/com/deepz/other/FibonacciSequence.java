package com.deepz.other;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * created by zhangdingping on 2019/9/13
 */
public class FibonacciSequence {

    static Map<Long, BigInteger> cache = new HashMap<>();

    static BigInteger fib(long n) {
        if (n == 1 || n == 2) {
            return BigInteger.ONE;
        }
        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        BigInteger a = fib(n - 1);
        BigInteger b = fib(n - 2);
        cache.put(n - 1, a);
        cache.put(n - 2, b);
        return a.add(b);
    }

    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        System.out.println("result= " + fib(1000));

        System.out.println((System.currentTimeMillis() - begin) + "ms");

    }
}
