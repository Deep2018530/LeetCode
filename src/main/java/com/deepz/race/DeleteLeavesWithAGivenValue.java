package com.deepz.race;

import com.deepz.linkedlist.TreeNode;

/**
 * created by zhangdingping on 2020/1/19
 * <p>
 * 删除给定的叶子结点  5317
 * <p>
 * 给你一棵以 root 为根的二叉树和一个整数 target ，请你删除所有值为 target 的 叶子节点 。
 * <p>
 * 注意，一旦删除值为 target 的叶子节点，它的父节点就可能变成叶子节点；如果新叶子节点的值恰好也是 target ，那么这个节点也应该被删除。
 * <p>
 * 也就是说，你需要重复此过程直到不能继续删除。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,2,3,2,null,2,4], target = 2
 * 输出：[1,null,3,null,4]
 * 解释：
 * 上面左边的图中，绿色节点为叶子节点，且它们的值与 target 相同（同为 2 ），它们会被删除，得到中间的图。
 * 有一个新的节点变成了叶子节点且它的值与 target 相同，所以将再次进行删除，从而得到最右边的图。
 * <p>
 * 示例 2：
 * <p>
 * 输入：root = [1,3,3,3,2], target = 3
 * 输出：[1,3,null,null,2]
 * <p>
 * 示例 3：
 * <p>
 * 输入：root = [1,2,null,2,null,2], target = 2
 * 输出：[1]
 * 解释：每一步都删除一个绿色的叶子节点（值为 2）。
 * <p>
 * 示例 4：
 * <p>
 * 输入：root = [1,1,1], target = 1
 * 输出：[]
 * <p>
 * 示例 5：
 * <p>
 * 输入：root = [1,2,3], target = 1
 * 输出：[1,2,3]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= target <= 1000
 * 每一棵树最多有 3000 个节点。
 * 每一个节点值的范围是 [1, 1000] 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-leaves-with-a-given-value
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DeleteLeavesWithAGivenValue {

    public TreeNode removeLeafNodes(TreeNode root, int target) {

        return dfs(null, root, target);
    }

    private TreeNode dfs(TreeNode fa, TreeNode cur, int target) {
        if (cur == null) return null;

        TreeNode ans = new TreeNode(cur.val);

        ans.left = dfs(cur, cur.left, target);
        ans.right = dfs(cur, cur.right, target);

        if (ans.left == null && ans.right == null && ans.val == target) {
            ans = null;
        }

        return ans;
    }
}
