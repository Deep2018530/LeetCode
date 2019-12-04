package com.deepz.test;

import com.deepz.linkedlist.week2.ListNode;

/**
 * created by zhangdingping at 2019/12/4
 * <p>
 * 2 两数相加
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1, q = l2, dummy = new ListNode(0);
        ListNode cur = dummy;

        int carry = 0;
        while (p != null || q != null) {
            int x = p != null ? p.val : 0;
            int y = q != null ? q.val : 0;
            int sum = x + y + carry;

            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }

        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
