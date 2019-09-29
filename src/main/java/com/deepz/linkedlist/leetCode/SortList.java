package com.deepz.linkedlist.leetCode;

import com.deepz.linkedlist.week2.ListNode;

/**
 * created by zhangdingping on 2019/9/30
 * 148 排序列表
 */
public class SortList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        fast = slow;
        slow = slow.next;
        fast.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        return merge(left, right);
    }

    public static ListNode merge(ListNode node1, ListNode node2) {

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while (node1 != null && node2 != null) {
            if (node1.val > node2.val) {
                cur.next = node2;
                node2 = node2.next;
            } else {
                cur.next = node1;
                node1 = node1.next;
            }
            cur = cur.next;
        }
        cur.next = node1 != null ? node1 : node2;
        return dummy.next;
    }
}
