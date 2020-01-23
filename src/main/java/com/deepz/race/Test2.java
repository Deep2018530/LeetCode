package com.deepz.race;


import com.deepz.linkedlist.TreeNode;
import com.deepz.linkedlist.week2.ListNode;

import java.util.ArrayList;
import java.util.List;

class Test2 {

    public static void main(String[] args) {

        Test2 test2 = new Test2();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);
        test2.FindPath(root, 22);

    }

    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        dfs(root, target);
        return ans;
    }

    private void dfs(TreeNode node, int target) {
        if (node == null) return;
        path.add(node.val);

        if (node.left == null && node.right == null && target - node.val == 0) ans.add(new ArrayList<>(path));

        dfs(node.left, target - node.val);
        dfs(node.right, target - node.val);
        path.remove(path.size() - 1);
    }
}