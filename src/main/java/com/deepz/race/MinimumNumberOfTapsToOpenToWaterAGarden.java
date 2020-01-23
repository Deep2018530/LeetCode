package com.deepz.race;

import java.util.Arrays;

/**
 * created by zhangdingping on 2020/1/19
 */
public class MinimumNumberOfTapsToOpenToWaterAGarden {

    public int minTaps(int n, int[] ranges) {

        int _n = ranges.length;

        int[] dp = new int[10050];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 0; i < _n; i++) {

            int left = Math.max(i - ranges[i], 0);
            int right = Math.min(i + ranges[i], n);

            for (int j = left; j < right; j++) {
                if (dp[j] == -1) continue;

                if (dp[right] == -1 || dp[right] > dp[j] + 1) dp[right] = dp[j] + 1;
            }
        }

        return dp[n];
    }
}
