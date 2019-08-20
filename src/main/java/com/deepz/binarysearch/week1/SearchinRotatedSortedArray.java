package com.deepz.binarysearch.week1;

/**
 * created by zhangdingping on 2019/8/20
 * 题号:33
 */
public class SearchinRotatedSortedArray {

    public int search(int[] nums, int target) {

        //找到中点(旋转点)
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int mid = l + r + 1 >> 1;

            if (nums[mid] < nums[nums.length - 1]) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        //判断target在左边还是右边 然后二分寻找
        if (target >= nums[l]) {
            l = r;
            r = nums.length - 1;
        } else {
            l = 0;
            r = r - 1;
        }

        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (target >= nums[mid]) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }

        return l;
    }
}
