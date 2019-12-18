package com.deepz.dfs.week5;

import java.util.*;

/**
 * created by zhangdingping at 2019/12/18
 * 216
 * <p>
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * <p>
 * 说明：
 * <p>
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 * <p>
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class CombinationSum3 {

    List<List<Integer>> ans = new ArrayList<>();

    // 尽量不要使用遗留类Stack,Deque完成可以实现栈
    Deque<Integer> path = new ArrayDeque<>();

    /**
     * 整体思路
     *
     * @param k k个数
     * @param n 组合成n（累加和为n)
     *          组合数范围1~9，且不重复
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(k, n, 1);
        return ans;
    }

    /**
     * @param k     k个数
     * @param n     组合成n（累加和为n)
     * @param start 组合数范围start~9，且不重复
     */
    private void dfs(int k, int n, int start) {
        if (k < 0 || n < 0) return;   // 剪枝

        // 刚好k个数、刚好递减成0（说明这k个数累加和刚好为n)
        if (k == 0 && n == 0) {
            if (!path.isEmpty())
                ans.add(new ArrayList<>(path));
            return;
        }

        // 从start开始，到9的范围，然后就是递归分支（选、不选) 记得恢复状态
        for (int i = start; i < 10; i++) {
            path.push(i);
            dfs(k - 1, n - i, ++start);
            path.pop();
        }
    }
}
