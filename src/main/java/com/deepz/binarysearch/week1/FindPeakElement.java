package com.deepz.binarysearch.week1;

/**
 * created by zhangdingping on 2019/8/22
 * 题号：162 寻找峰值
 */
public class FindPeakElement {

    public int findPeakElement(int[] nums) {

        int l = 0, r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[mid + 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

   /* int l = 0, r = nums.length - 1;

        while (l < r) {
        int mid = l + (r - l) / 2;
        if (nums[mid + 1] > nums[mid]) {
            l = mid + 1;
        } else {
            r = mid;
        }
    }

        return l;*/
}
