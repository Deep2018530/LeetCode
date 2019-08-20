package com.deepz.binarysearch.week1;

/**
 * created by zhangdingping on 2019/8/20
 * 题号:33
 */
public class SearchinRotatedSortedArray {

    public static void main(String[] args) {
        search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
    }

    public static int search(int[] nums, int target) {

        if (nums.length == 0) {
            return -1;
        }

        //找到中点(旋转点)
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int mid = l + r >> 1;

            if (nums[mid] <= nums[nums.length - 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        //判断target在左边还是右边 然后二分寻找
        if (target <= nums[nums.length - 1]) {
            r = nums.length - 1;
        } else {
            l = 0;
            r--;
        }

        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        if (nums[l] == target) {
            return l;
        }
        return -1;
    }
}
