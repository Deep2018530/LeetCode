package com.deepz.dp;

/**
 * created by zhangdingping at 2019/12/11
 * JK 40 one
 */
public class JK {

    // weight: 物品重量, n: 物品个数  w: 背包可承载重量
    public int knapsack(int[] weight, int n, int w) {
        boolean[][] states = new boolean[n][w + 1];
        // 初始化第一行的状态(方便后面的“状态转移”)
        states[0][0] = true;
        if (weight[0] <= w) {
            states[0][weight[0]] = true;
        }

        for (int i = 1; i < n; ++i) {
            // 状态转移(将之前的物品，放与不放的状态都转移（下移))
            for (int j = 0; j <= w; ++j) {
                if (states[i - 1][j] == true) states[i][j] = states[i - 1][j];
            }

            // 选择放入第i个物品到背包(在之前的状态上修改（加上当前物品的重量),如果不放的话，那就是之前的状态+0，这一步在"状态转移“就已经做了
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

    public static int knapsack2(int[] item, int n, int w) {

        boolean[] states = new boolean[w + 1];
        states[0] = true;
        if (item[0] <= w) {
            states[item[0]] = true;
        }
        for (int i = 1; i < n; ++i) {
            for (int j = w - item[i]; j >= 0; --j) {
                if (states[j] == true) states[j + item[i]] = true;
            }
        }
        for (int i = w; i >= 0; --i) {
            if (states[i] == true) return i;
        }
        return 0;
    }
}
