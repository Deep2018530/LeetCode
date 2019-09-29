package com.deepz.linkedlist.leetCode;

import com.deepz.linkedlist.TreeNode;
import com.deepz.linkedlist.week2.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * created by zhangdingping on 2019/9/29
 * 109 有序链表转换二叉搜索树
 */
public class ConvertSortedListtoBinarySearchTree {

    private List<Integer> values;

    public ConvertSortedListtoBinarySearchTree() {
        this.values = new ArrayList<>();
    }

    private void mapListToValues(ListNode head) {
        while (head != null) {
            this.values.add(head.val);
            head = head.next;
        }
    }

    private TreeNode convertListToBST(int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(this.values.get(mid));

        if (left == right) {
            return node;
        }

        node.left = convertListToBST(left, mid - 1);
        node.right = convertListToBST(mid + 1, right);
        return node;
    }

    public TreeNode sortedListToBST(ListNode head) {
        this.mapListToValues(head);
        return convertListToBST(0, this.values.size() - 1);
    }
}
