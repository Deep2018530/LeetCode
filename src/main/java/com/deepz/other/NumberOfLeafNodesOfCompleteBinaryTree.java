package com.deepz.other;

import com.deepz.linkedlist.TreeNode;

/**
 * created by zhangdingping on 2020/1/28
 * 完全二叉树的节点个数
 */
public class NumberOfLeafNodesOfCompleteBinaryTree {

    public int nodeNum(TreeNode root) {
        if (root == null) return 0;

        return bs(root, 1, leftTreeLevel(root, 1));
    }

    /**
     * 如果当前节点的右子树的最大深度到了当前节点树的总高度，说明当前节点的左子树一定是满二叉树，否则当前节点的右子树也一定是满二叉树（不过高度要比当前节点树的高度 - 1)
     *
     * @param cur
     * @param level
     * @param h
     * @return
     */
    public int bs(TreeNode cur, int level, int h) {
        if (level == h) return 1;

        if (leftTreeLevel(cur.right, level + 1) == h) return (1 << (h - level)) + bs(cur.right, level + 1, h);
        else return (1 << (h - level - 1)) + bs(cur.left, level + 1, h);

    }

    /**
     * @param node
     * @param level 当前层级
     * @return node为头结点的树的最大深度（level层)
     */
    public int leftTreeLevel(TreeNode node, int level) {
        while (node != null) {
            level++;
            node = node.left;
        }

        return level - 1;
    }
}
