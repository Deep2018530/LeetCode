package com.deepz.race;

import java.util.Arrays;

/**
 * created by zhangdingping on 2020/5/11
 */
public class Test3 {

    public static void main(String[] args) {
        missingTwo(new int[]{2,3});
    }

    public static int[] missingTwo(int[] nums) {

        if (nums == null || nums.length == 0) return new int[]{};

        int n = nums.length;
        int[] temp = Arrays.copyOf(nums, n + 2);
        temp[n] = 1;
        temp[n + 1] = 1;

        for (int i = 0; i < temp.length; i++) {
            temp[Math.abs(temp[i])] *= -1;
        }

        int[] ans = new int[2];
        for (int i = 0, j = 0; i < temp.length; i++) {
            if (temp[i] > 0) {
                ans[j++] = i + 1;
            }
        }

        return ans;
    }
}
