package com.deepz.dfs.week5;

import java.util.*;

/**
 * created by zhangdingping at 2019/12/17
 * <p>
 * 不能有重复的子集，计算每个数字可以出现的次数
 * <p>
 * 90
 */
public class Subsets2 {

    private Set<List<Integer>> ans = new HashSet<>();
    private Stack<Integer> path = new Stack<>();
    private int n;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        n = nums.length;

        dfs(0, nums);

        return new ArrayList<>(ans);

    }

    /**
     * @param p    当前位置
     * @param nums
     */
    public void dfs(int p, int[] nums) {
        if (p == n) {
            ans.add(new ArrayList<>(path));
            return;
        }

        int k = 0;
        while (p + k < n && nums[p + k] == nums[p]) k++;

        for (int i = 0; i <= k; i++) {
            dfs(p + k, nums);
            path.push(nums[p]);
        }

        for (int i = 0; i < k; i++) {
            path.pop();
        }

    }
}
