package com.deepz.tree.week3;

import com.deepz.linkedlist.TreeNode;

/**
 * created by zhangdingping on 2019/10/4
 * 236 二叉树的最近公共祖先
 */
public class LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果以rootroot为根的子树中包含p和q，则返回它们的最近公共祖先
        // 如果只包含p,则返回p
        // 如果只包含q,则返回q
        // 如果都不包含，则返回null
        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}
