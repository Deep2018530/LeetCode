package com.deepz.linkedlist.leetCode;

import com.deepz.linkedlist.week2.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * created by zhangdingping on 2019/9/29
 * 24 两两交换节点
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        //第一个节点
        ListNode first = head;
        //第二个节点
        ListNode second = head.next;

        //保存记录第二个节点后的节点引用
        ListNode next = second.next;

        //第二个节点指向第一个节点
        second.next = first;

        //第二个节点指向第一个节点，第一个节点指向(原第二个节点的下一个节点)
        first.next = swapPairs(next);

        return second;
    }

}
