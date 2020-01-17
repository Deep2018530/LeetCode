package com.deepz.race;

import com.deepz.linkedlist.week2.ListNode;

import java.util.*;


class Test2 {

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        System.out.println(test2.Power(2, -3));
    }

    public double Power(double base, int exponent) {


        if (exponent == 0) return 1;
        if (exponent == 1) return base;

        boolean flag = exponent < 0 ? true : false;
        if (flag) exponent = Math.abs(exponent);

        double result = Power(base, exponent >> 1);
        result *= result;
        if ((exponent & 1) == 1) result *= base;

        return flag ? 1 / result : result;
    }
}