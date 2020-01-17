package com.deepz.offer;

/**
 * created by zhangdingping on 2020/1/17
 * <p>
 * 剪绳子 动态规划 || 贪婪
 */
public class CutRope {

    public int cutRope(int target) {
        int[] dp = new int[target + 1];

        if (target == 2) return 1;
        if (target == 3) return 2;

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        int max;

        for (int i = 4; i <= target; i++) {
            max = 0;

            for (int j = 1; j <= i / 2; j++) {
                int temp = dp[j] * dp[i - j];
                if (temp > max) max = temp;
            }
            dp[i] = max;
        }
        return dp[target];
    }

}
