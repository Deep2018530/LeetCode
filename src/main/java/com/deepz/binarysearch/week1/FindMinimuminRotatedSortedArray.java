package com.deepz.binarysearch.week1;

/**
 * created by zhangdingping on 2019/8/20
 * 题号:153
 */
public class FindMinimuminRotatedSortedArray {

    public int findMin(int[] nums) {

        int length = nums.length;

        int l = 0, r = length - 1;
        while (l < r) {

            int mid = l + r >> 1;
            if (nums[mid] <= nums[length - 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return nums[r];
    }
}
