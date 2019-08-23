package com.deepz.binarysearch.week1;

/**
 * created by zhangdingping on 2019/8/23
 * 题号: 287 寻找重复数
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 */
public class FindtheDuplicateNumber {

    /*不能更改原数组（假设数组是只读的）。
    只能使用额外的 O(1) 的空间。
    时间复杂度小于 O(n2) 。
    数组中只有一个重复的数字，但它可能不止重复出现一次。*/

    public int findDuplicate(int[] nums) {

        int n = nums.length - 1;
        int l = 1, r = n;    // 将数字作为二分区间  1 - n

        while (l < r) {

            int mid = l + (r - l) / 2;  // 两数之间的mid

            int cnt = 0;
            for (int num : nums) {
                if (num <= mid && num >= l) {   //遍历数组 如果 某一个数字大于等于l 并且小于等于mid，那么他就属于左区间
                    cnt++;
                }
            }

            if (cnt > mid - l + 1) {       //如果左区间的数的个数 大于 左区间的“抽屉”数，那么答案一定在左边
                r = mid;                   // 比如  l = 1 r = 10 那么 mid = 5， 1 - 5 有 5个抽屉，
                                            // 遍历数组(长度10+1),如果数字在1-5之间就计数+1,
                                           // 如 1 2 3 5 6 8 7 3 4 9 10  mid 为 5,1-5的数在整个数组中有1 2 3 3 4 5,共6个，
                                          // 而抽屉数是5-1+1 = 5个，总共5个抽屉你要放6个数，肯定有一个抽屉放两个数，所以答案锁定在左边，反之右边
            } else {
                l = mid + 1;               //反之答案在右边
            }
        }

        return l;
    }
}
