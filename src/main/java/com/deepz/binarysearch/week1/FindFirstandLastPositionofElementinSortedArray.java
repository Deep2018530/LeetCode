package com.deepz.binarysearch.week1;

/**
 * created by zhangdingping on 2019/8/19
 * 题号：34
 */
public class FindFirstandLastPositionofElementinSortedArray {

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};

        int l = 0, r = nums.length - 1;

        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        if (nums[r] != target) {
            return new int[]{-1, -1};
        }
        int start = r;


        l = 0;
        r = nums.length - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        int end = r;
        return new int[]{start, end};
    }
}
