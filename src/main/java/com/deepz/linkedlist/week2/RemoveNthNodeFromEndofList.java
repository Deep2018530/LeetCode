package com.deepz.linkedlist.week2;

/**
 * created by zhangdingping on 2019/8/23
 * 题号：19 删除链表的倒数第N个节点
 */
public class RemoveNthNodeFromEndofList {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(-1);

        dummy.next = head;

        ListNode first = dummy, second = dummy;
        while (n-- > 0) {
            first = first.next;
        }

        //两个指针隔着n步 同时向后移动，当后指针到了尾节点，那前指针指向的是倒数第n+1个节点。
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;

        return dummy.next;
    }
}
