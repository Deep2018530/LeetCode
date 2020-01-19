package com.deepz.offer;

import com.deepz.linkedlist.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

/**
 * created by zhangdingping on 2020/1/18
 * <p>
 * 打印二叉树 分多行
 */
public class PrintTreeMutilLine {

    /**
     * 以 null 作为行结束标识
     *
     * @param pRoot
     * @return
     */
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (pRoot == null) return ans;

        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(pRoot);
        queue.addLast(null);

        ArrayList<Integer> path = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.pollFirst();
            if (node == null) {
                if (path.isEmpty()) break;
                ans.add(new ArrayList<>(path));
                path.clear();
                queue.addLast(null);
                continue;
            }
            path.add(node.val);
            if (node.left != null) queue.addLast(node.left);
            if (node.right != null) queue.addLast(node.right);
        }

        return ans;
    }
}
