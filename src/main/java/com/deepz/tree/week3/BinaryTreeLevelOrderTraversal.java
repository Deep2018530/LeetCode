package com.deepz.tree.week3;

import com.deepz.linkedlist.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * created by zhangdingping on 2019/10/4
 * 102 二叉树的层次遍历
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public static void helper(TreeNode root, List<List<Integer>> res) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new ArrayDeque();
        queue.add(root);

        while (!queue.isEmpty()) {
            int len = queue.size();
            //记录每一层的结果
            List<Integer> list = new ArrayList<>();
            //取出当前层所有节点(len是队列长度)
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                //如果该节点有左节点，则放入队列(此时队列size增大，但是不影响遍历，因为len的值早就取出来了)
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            //记录每一层的值集合
            res.add(list);
        }
    }
}
