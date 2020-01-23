package com.deepz.offer;

import com.deepz.linkedlist.TreeNode;

import java.util.ArrayList;

/**
 * created by zhangdingping on 2020/1/23
 * <p>
 * 二叉树中和为某一值的路径 （根节点到叶子结点）
 */
public class TreePathValue {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        dfs(root, target);
        return ans;
    }

    private void dfs(TreeNode node, int target) {
        if (node == null) return;

        path.add(node.val);
        target -= node.val;

        if (node.left == null && node.right == null && target == 0) ans.add(new ArrayList<>(path));

        dfs(node.left, target);
        dfs(node.right, target);

        path.remove(path.size() - 1);
    }
}
