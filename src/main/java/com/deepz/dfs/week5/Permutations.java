package com.deepz.dfs.week5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * created by zhangdingping at 2019/12/11
 * 46 全排列；
 */
public class Permutations {

    boolean[] st;
    int n;
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        st = new boolean[n];
        Arrays.fill(st, false);

        dfs(nums, 0);
        return ans;
    }

    private void dfs(int[] nums, int k) {
        if (k == n) {
            List<Integer> temp = new ArrayList<>();
            temp.addAll(path);
            ans.add(temp);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!st[i]) {
                st[i] = true;
                path.addLast(nums[i]);
                dfs(nums, k + 1);
                path.removeLast();
                st[i] = false;
            }
        }
    }

}
