package com.deepz.linkedlist.week2;

/**
 * created by zhangdingping on 2019/8/23
 * 题号：237 删除链表中的节点
 */
public class DeleteNodeinaLinkedList {

    public void deleteNode(ListNode node) {

        //脑筋急转弯... 社会
        //删除当前结点转换成，将下一个结点的值覆盖当前结点的值，然后删除下一个结点。这就变相地删除了当前结点
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
