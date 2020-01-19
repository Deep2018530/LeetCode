package com.deepz.race;


import com.deepz.linkedlist.TreeNode;
import com.deepz.linkedlist.week2.ListNode;

import java.util.ArrayList;
import java.util.List;

class Test2 {

    public static void main(String[] args) {

        Test2 test2 = new Test2();
        TreeNode node = new TreeNode(-1);
        node.left = new TreeNode(-2);
        delete(node);
        System.out.println(node.left);

    }

    private static void delete(TreeNode node) {
        node.left = null;
    }

    public List<String> printVertically(String s) {
        String[] split = s.split("\\s+");
        int maxLen = 0;

        for (int i = 0; i < split.length; i++) {
            maxLen = Math.max(maxLen, split[i].length());
        }

        char[][] a = new char[split.length][maxLen];



        return null;
    }
}