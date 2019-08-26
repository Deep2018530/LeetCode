package com.deepz.binarysearch.week2;

/**
 * created by zhangdingping on 2019/8/23
 * 题号：61旋转链表
 */
public class RotateList {

    /* 这道题中 k 可能很大，所以我们令 k=k%n，n是链表长度。
    创建两个指针first, second，分别指向虚拟头结点，先让first向后移动 k个位置，然后first和second同时向后移动，直到first走到链表最后一个元素。
    此时first指向链表末尾，second指向分界点。然后我们把链表从分界点处断开，然后把后半段接在前半段前面即可。
    时间复杂度分析：链表一共遍历2遍，所以总时间复杂度是 O(n)*/


    public ListNode rotateRight(ListNode head, int k) {

        if (head == null) return null;

        int n = 1;
        ListNode node = head;
        while (node.next != null) {
            node = node.next;
            n++;
        }

        k %= n;
        if (k == 0) return head;

        ListNode first = head;
        while (first.next != null && k-- > 0) {
            first = first.next;
        }

        ListNode second = head;
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        first.next = head;
        head = second.next;
        second.next = null;

        return head;
    }
}
