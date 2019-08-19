package com.deepz.binarysearch.week1;

/**
 * created by zhangdingping on 2019/8/19
 * 题号：35
 */
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {

        if (nums.length <= 0 || nums[nums.length - 1] < target) return nums.length;


        int l = 0, r = nums.length - 1;

        while (l < r) {
            int mid = l + r >> 1;

            if (target <= nums[mid]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

}
