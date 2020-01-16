package com.deepz.offer;

/**
 * created by zhangdingping on 2020/1/16
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class Nextnodeofbinarytree {

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) return pNode;

        if (pNode.right != null) {
            TreeLinkNode right = pNode.right;
            while (right.left != null) {
                right = right.left;
            }
            return right;
        } else {
            TreeLinkNode parent = pNode.next;
            while (parent != null && parent.right == pNode) {
                pNode = parent;
                parent = parent.next;
            }
            return parent;
        }
    }

}
