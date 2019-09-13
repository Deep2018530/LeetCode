package com.deepz.dp;

/**
 * created by zhangdingping on 2019/9/13
 * 0 1背包
 */
public class Test {

    static int[] w = {2, 1, 3, 2}; // 重量表
    static int[] v = {3, 2, 4, 2}; //价值表
    static int n = 4; //物品数量
    static int W = 5; //背包的承重极限


    public static void main(String[] args) {
        System.out.println(dp());
    }

    static int dp() {

        int[][] dp = new int[n][W + 1];
        //初始化dp表的第一行
        for (int i = 0; i < W + 1; i++) {
            if (i >= w[0]) {  //每种容量-0号物品
                dp[0][i] = v[0];
            } else {
                dp[0][i] = 0;
            }
        }

        //其他行
        for (int i = 1; i < n; i++) {
            //j是列，也是背包的剩余容量
            for (int j = 0; j < W + 1; j++) {
                if (j >= w[i]) { // 要的起
                    int i1 = v[i] + dp[i - 1][j - w[i]]; // 选择当前物品即i好物品，剩余容量
                    int i2 = dp[i - 1][j];
                    dp[i][j] = Math.max(i1, i2);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n - 1][W];
    }

}


