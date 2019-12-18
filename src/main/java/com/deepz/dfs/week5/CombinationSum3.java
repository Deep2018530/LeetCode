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
    Stack<Integer> path = new Stack<>();

    //本来用的Stack（dfs中的方法没有判断k<0,只有n<0),结果2ms，打败30%多。
    //后来郁闷看题解，看到有说Deque好，我就换成了(Deque),结果1ms了。
    //Deque<Integer> path = new ArrayDeque<>();

    //不过再后来，我又想了下，可以加个剪枝条件(k<0),因为k<0也没必要递归下去了，然后继续使用Stack，结果1ms。
    //说明剪枝条件也挺重要，不过同样条件下，Deque比Stack性能好貌似，回头研究下，有大佬明白也可以留言指教下哈~嘿嘿


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
