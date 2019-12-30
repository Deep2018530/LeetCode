package com.deepz.week6;

/**
 * created by zhangdingping on 2019/12/29
 * 88
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int newIndex = m + n - 1;
        int p = m - 1;
        int q = n - 1;

        while (q >= 0 && p >= 0) {
            if (nums1[p] < nums2[q]) {
                nums1[newIndex--] = nums2[q--];
            } else if (nums2[q] < nums1[p]) {
                nums1[newIndex--] = nums1[p--];
            } else {
                nums1[newIndex--] = nums1[p--];
                nums1[newIndex--] = nums2[q--];
            }
        }

        while (p >= 0) nums1[newIndex--] = nums1[p--];
        while (q >= 0) nums1[newIndex--] = nums2[q--];

    }

}