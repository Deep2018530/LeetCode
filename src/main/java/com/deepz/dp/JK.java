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


    public static int knapsack3(int[] weight, int[] value, int n, int w) {
        int[][] states = new int[n][w + 1];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < w + 1; ++j) {
                states[i][j] = -1;
            }
        }

        states[0][0] = 0;
        if (weight[0] <= w) {
            states[0][weight[0]] = value[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                if (states[i - 1][j] >= 0) states[i][j] = states[i - 1][j];
            }

            for (int j = 0; j <= w - weight[i]; ++j) {
                if (states[i - 1][j] >= 0) {
                    int v = states[i - 1][j] + value[i];
                    if (v > states[i][j + weight[i]]) {
                        states[i][j + weight[i]] = v;
                    }
                }
            }

        }

        // 找出最大值
        int maxvalue = -1;
        for (int j = 0; j <= w; j++) {
            if (states[n - 1][j] > maxvalue) maxvalue = states[n - 1][j];
        }
        return maxvalue;
    }


    // items商品价格,n 商品个数，w表示满减条件，比如200
    public static void double11advance(int[] items, int n, int w) {
        boolean[][] states = new boolean[n][3 * w + 1];
        states[0][0] = true;
        if (items[0] <= 3 * w) {
            states[0][items[0]] = true;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3 * w; j++) {
                if (states[i - 1][j] == true) states[i][j] = states[i - 1][j];
            }
            for (int j = 0; j <= 3 * w - items[i]; j++) {
                if (states[i - 1][j] == true) states[i][j + items[i]] = true;
            }
        }

        int j;
        for (j = w; j < 3 * w + 1; j++) {
            if (states[n - 1][j] == true) break;
        }
        if (j == 3 * w + 1) return;
        for (int i = n - 1; j >= 1; i--) {
            if (j - items[i] >= 0 && states[i - 1][j - items[i]] == true) {
                System.out.println(items[i] + " ");
                j = j - items[i];
            }
        }
        if (j != 0) System.out.println(items[0]);
    }

    public static void test() {

    }
}
