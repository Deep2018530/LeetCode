package com.deepz.linkedlist.leetCode;

import com.deepz.linkedlist.week2.ListNode;

/**
 * created by zhangdingping on 2019/9/28
 * 141 环形链表
 */
public class LinkedListCycle {

    /** 
     * created by zhangdingping on 2019/9/28
     * 双指针，一个走的快一个走得慢，如果重叠则一定有环
     */
    
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }

        return false;
    }
}
