package com.deepz.linkedlist.leetCode;

import com.deepz.linkedlist.week2.ListNode;

/**
 * created by zhangdingping on 2019/9/29
 * 234 回文链表
 */
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        ListNode temp = head;

        int len = 0;
        while (temp != null) {
            temp = temp.next;
            len++;
        }

        ListNode pre = null;
        ListNode cur = head;
        //反转前半部分链表
        for (int i = 0; i < len / 2; i++) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        //如果是奇数长度链表 后面的指针需要向后移位一步(这样才能对称，接下来就是pre向"前"走，cur向后走，两两比较了)
        if (len % 2 == 1) {
            cur = cur.next;
        }

        //循环比较是否相同，否则不是回文链表
        while (pre != null) {
            if (pre.val != cur.val) {
                return false;
            }
            pre = pre.next;
            cur = cur.next;
        }

        return true;
    }
}
