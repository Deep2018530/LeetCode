package com.deepz.race;


import com.deepz.linkedlist.TreeNode;
import com.deepz.linkedlist.week2.ListNode;

import java.util.*;

class Test2 {

    public static void main(String[] args) {

        Test2 test2 = new Test2();
    }


    public String ReverseSentence(String str) {

        String[] split = str.split("\\s+");

        StringBuffer ans = new StringBuffer();
        for (int i = split.length - 1; i >= 0; i--) {
            ans.append(new StringBuffer(split[i]).reverse());
            ans.append(" ");
        }


        return ans.toString();
    }
}