package com.deepz.dp;

/**
 * created by zhangdingping at 2019/12/11
 * JK 40 one
 */
public class JK {

    // weight: 物品重量, n: 物品个数  w: 背包可承载重量
    public int knapsack(int[] weight, int n, int w) {
        boolean[][] states = new boolean[n][w + 1];
        states[0][0] = true;
        if (weight[0] <= w) {
            states[0][weight[0]] = true;
        }

        for (int i = 1; i < n; ++i) {
            // 状态转移
            for (int j = 0; j <= w; ++j) {
                if (states[i - 1][j] == true) states[i][j] = states[i - 1][j];
            }

            // 选择放入第i个物品到背包
            for (int j = 0; j <= w - weight[i]; ++j) {
                if (states[i - 1][j] == true) states[i][j + weight[i]] = true;
            }
        }
        // 输出结果（重量）
        for (int i = w; i >= 0; --i) {
            if (states[n - 1][i] == true) return i;
        }
        return 0;
    }
}
