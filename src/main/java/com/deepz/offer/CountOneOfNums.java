package com.deepz.offer;

/**
 * created by zhangdingping on 2020/1/17
 * <p>
 * 二进制中1的个数
 */
public class CountOneOfNums {

    public int NumberOf1(int n) {

        int ans = 0;
        int flag = 1;

        while (flag != 0) {
            if ((n & flag) != 0) ans++;    //注意不能条件是 == 1，因为flag左移，所以与操作后不一定是1
            flag <<= 1;                    // 注意不能通过n来右移逐步计算，因为如果是负数会有问题。
        }

        return ans;
    }

}
