package com.deepz.race;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * created by zhangdingping on 2020/1/12
 * <p>
 * 祖父节点值为偶数的节点和  5145
 * 给你一棵二叉树，请你返回满足以下条件的所有节点的值之和：
 * <p>
 * 该节点的祖父节点的值为偶数。（一个节点的祖父节点是指该节点的父节点的父节点。）
 * <p>
 * 如果不存在祖父节点值为偶数的节点，那么返回 0 。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * 输出：18
 * 解释：图中红色节点的祖父节点的值为偶数，蓝色节点为这些红色节点的祖父节点。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点的数目在 1 到 10^4 之间。
 * 每个节点的值在 1 到 100 之间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-nodes-with-even-valued-grandparent
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SumofNodeswithEvenValuedGrandparent {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    /**
     * 广度搜索层序遍历
     * 当前节点为偶数,则把flag标识为true,并在后续处理中，将当前节点的左右非空儿子节点的 value 改为负数（一种标识）
     *
     * 从队列中弹出节点，如果节点的值是负数，说明节点的父节点是偶数，那么就需要把节点的左右非空儿子节点的 value 记录。
     *
     * @param root
     * @return
     */

    public int sumEvenGrandparent(TreeNode root) {

        int ans = 0;

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);

        while (!queue.isEmpty()) {

            boolean flag = false;
            TreeNode node = queue.pop();
            if (node == null) continue;

            if ((node.val & 1) == 0) {
                flag = true;
            }

            if (node.left != null) {
                queue.addLast(node.left);
                if (node.val < 0) {
                    ans += node.left.val;
                }

                if (flag) {
                    node.left.val *= -1;
                }
            }

            if (node.right != null) {
                queue.addLast(node.right);
                if (node.val < 0) {
                    ans += node.right.val;
                }

                if (flag) {
                    node.right.val *= -1;
                }
            }
        }
        return ans;
    }
}
