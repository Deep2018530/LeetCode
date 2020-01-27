package com.deepz.race;


import com.deepz.linkedlist.TreeNode;
import com.deepz.linkedlist.week2.ListNode;

import java.util.*;

class Test2 {

    public static void main(String[] args) {

        Test2 test2 = new Test2();
        test2.lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6});
    }

    public int lengthOfLIS(int[] nums) {

        int n = nums.length;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) res = Math.max(res,dp[i]);

        return res;
    }

}