package com.deepz.linkedlist.week2;

/**
 * created by zhangdingping on 2019/8/27
 * 题号：83 删除链表中的重复元素
 */
public class RemoveDuplicatesfromSortedList {

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return head;
        }

        ListNode p = head;

        while (p.next != null) {
            if (p.val == p.next.val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return head;
    }
}
