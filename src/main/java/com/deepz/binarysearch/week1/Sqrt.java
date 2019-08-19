package com.deepz.binarysearch.week1;

/**
 * created by zhangdingping on 2019/8/19
 * 题号:69
 */
public class Sqrt {

    public int mySqrt(int x) {

        int l = 0, r = x;

        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (mid <= x / mid) {   //mid * mid < x 两个整数可能会溢出
                l = mid;
            } else {
                r = mid - 1;
            }
        }

        return l;
    }
}
