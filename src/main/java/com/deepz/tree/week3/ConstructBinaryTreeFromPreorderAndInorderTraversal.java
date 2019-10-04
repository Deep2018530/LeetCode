package com.deepz.tree.week3;

import com.deepz.linkedlist.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * created by zhangdingping on 2019/10/4
 * 105 从前序与中序遍历列构造二叉树
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    static Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, inorder, 0, n - 1, 0, n - 1);

    }

    public static TreeNode buildTreeHelper(int[] preorder, int[] inorder, int pl, int pr, int il, int ir) {
        //pl 先序遍历的起点下标 pr 先序遍历的终点下标
        //il 中序遍历的起点下标 ir 中序遍历的终点下标
        if (pl > pr) {
            return null;
        }
        int val = preorder[pl];
        //根节点在中序遍历中的下标
        int k = map.get(val);
        // 获取左子树的长度
        int len = k - il;
        //记录根节点的值
        TreeNode root = new TreeNode(val);
        //左子树
        // 左子树的先序遍历的范围，是根节点+1到根节点+左子树的长度
        // 左子树的中序遍历的范围, 是左子树的中序遍历起点到中序遍历中根节点-1
        root.left = buildTreeHelper(preorder, inorder, pl + 1, pl + len, il, k - 1);
        //右子树
        // 先序遍历的范围，根节点+左子树的长度+1到原先序遍历的终点
        // 中序遍历的范围, 根节点所在位置+1，到原中序遍历的终点
        root.right = buildTreeHelper(preorder, inorder, pl + len + 1, pr, k + 1, ir);

        return root;
    }

}
