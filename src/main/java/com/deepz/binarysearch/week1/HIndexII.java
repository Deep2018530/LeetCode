package com.deepz.binarysearch.week1;

/**
 * created by zhangdingping on 2019/8/23
 * 题号：275
 */
public class HIndexII {

    public int hIndex(int[] nums) {

        int l = 0, r = nums.length;

        while (l < r) {
            int mid = l + r + 1 >> 1;

            if (nums[nums.length - mid] >= mid) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }

        return l;
    }
}
