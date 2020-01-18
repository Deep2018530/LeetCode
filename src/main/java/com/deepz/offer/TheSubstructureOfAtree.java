package com.deepz.offer;

import com.deepz.linkedlist.TreeNode;

/**
 * created by zhangdingping on 2020/1/18
 * 树的子结构
 */
public class TheSubstructureOfAtree {


    public boolean HasSubtree(TreeNode root1, TreeNode root2) {

        if (root1 == null || root2 == null) return false;


        return doesTree1HasTree2(root1, root2)
                || HasSubtree(root1.left, root2)
                || HasSubtree(root1.right, root2);
    }

    private boolean doesTree1HasTree2(TreeNode tree1, TreeNode tree2) {
        if (tree2 == null) return true;
        if (tree1 == null) return false;

        if (tree1.val != tree2.val) return false;

        return doesTree1HasTree2(tree1.left, tree2.right) && doesTree1HasTree2(tree1.right, tree2.right);
    }
}
