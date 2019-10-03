package com.deepz.tree.week3;

import com.deepz.linkedlist.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * created by zhangdingping on 2019/10/4
 * <p>
 * 94 二叉树的中序遍历
 */
public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack();

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
