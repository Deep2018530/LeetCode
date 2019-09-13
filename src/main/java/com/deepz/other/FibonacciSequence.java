package com.deepz.other;

/**
 * created by zhangdingping on 2019/9/13
 */
public class FibonacciSequence {

    static int fib(int n) {


        if (n == 1 || n == 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        System.out.println(fib(2));

        System.out.println(System.currentTimeMillis() - begin / 1000);
    }
}
