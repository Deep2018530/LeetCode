package com.deepz.tree.week3;

import com.deepz.linkedlist.TreeNode;

import java.util.Stack;

/**
 * created by zhangdingping on 2019/10/3
 * 98 验证二叉搜索树
 */
public class ValildateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * 递归自顶向下判断 范围值是否符合
     *
     * @param root
     * @param min
     * @param max
     * @return
     */
    public static boolean dfs(TreeNode root, Long min, Long max) {

        if (root == null) {
            return true;
        }

        if (root.val < min || root.val > max) {
            return false;
        }

        return dfs(root.left, min, root.val - 1L) && dfs(root.right, root.val + 1L, max);

    }

    /**
     * 判断中序遍历严格单调递增
     *
     * @param root
     * @return
     */
    public boolean isValidBSTByInorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        double inorder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
}
