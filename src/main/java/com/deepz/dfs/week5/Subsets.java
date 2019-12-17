package com.deepz.dfs.week5;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * created by zhangdingping at 2019/12/17
 * 78
 */
public class Subsets {

    private List<List<Integer>> ans = new ArrayList<>();
    private Stack<Integer> path = new Stack<>();
    private int n;

    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;

        dfs(0, nums);

        return ans;

    }

    /**
     * @param p    当前位置
     * @param nums
     */
    public void dfs(int p, int[] nums) {
        // 如果当前位置到末尾了，说明所有位置都已经做过抉择了。
        if (p == n) {

            // 将当前路径（所有抉择的结果)添加到答案中
            ans.add(new ArrayList<>(path));
            return;
        }

        // 1. 选当前位置上的数字
        path.push(nums[p]);

        // 处理下一个位置
        dfs(p + 1, nums);

        // 回溯，返回状态
        path.pop();

        // 处理下一个位置（不选当前位置上的数字)
        dfs(p + 1, nums);
    }
}
