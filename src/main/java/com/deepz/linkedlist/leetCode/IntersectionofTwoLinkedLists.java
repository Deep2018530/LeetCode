package com.deepz.linkedlist.leetCode;

import com.deepz.linkedlist.week2.ListNode;

/**
 * created by zhangdingping on 2019/9/28
 * 160 相交链表
 */
public class IntersectionofTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pA = headA;
        ListNode pB = headB;

        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }

        return pA;
    }
}
