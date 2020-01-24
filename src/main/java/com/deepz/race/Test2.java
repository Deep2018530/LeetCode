package com.deepz.race;


import com.deepz.linkedlist.TreeNode;
import com.deepz.linkedlist.week2.ListNode;

import java.util.*;

class Test2 {

    public static void main(String[] args) {

        Test2 test2 = new Test2();

    }

    Set<String> ans = new HashSet<>();
    int len;
    boolean[] visit;
    public ArrayList<String> Permutation(String str) {
        len = str.length();
        visit = new boolean[len];
        dfs(str,0,new StringBuffer());
        ArrayList<String> res = new ArrayList<>(ans);
        Collections.sort(res);
        return res;
    }

    private void dfs(String str, int k , StringBuffer sb) {
        if (k >= len) {
            ans.add(sb.toString());
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!visit[i]){
                visit[i] = true;
                sb.append(str.charAt(i));
                dfs(str,k + 1,sb);
                sb.deleteCharAt(sb.length() - 1);
                visit[i] = false;
            }
        }

    }
}