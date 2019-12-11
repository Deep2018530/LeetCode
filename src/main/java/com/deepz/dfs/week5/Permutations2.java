package com.deepz.dfs.week5;

import java.util.*;

/**
 * created by zhangdingping at 2019/12/11
 * 47 全排列2
 */
public class Permutations2 {

    private List<List<Integer>> res = new ArrayList<>();
    private boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        Arrays.sort(nums);
        used = new boolean[len];
        dfs(nums, 0, new Stack<>());
        return res;
    }

    private void dfs(int[] nums, int depth, Stack<Integer> stack) {
        if (depth == nums.length) {
            res.add(new ArrayList<>(stack));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }

                used[i] = true;
                stack.add(nums[i]);
                dfs(nums, depth + 1, stack);
                stack.pop();
                used[i] = false;
            }

        }

    }
}
