package com.deepz.other;

import java.util.LinkedList;

/**
 * created by zhangdingping at 2019/12/27
 * <p>
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 * <p>
 * 给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 * 示例 2:
 * <p>
 * 输入: 2, [[1,0],[0,1]]
 * 输出: false
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 * 说明:
 * <p>
 * 输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
 * 你可以假定输入的先决条件中没有重复的边。
 * 提示:
 * <p>
 * 这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。
 * 通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。
 * 拓扑排序也可以通过 BFS 完成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/course-schedule
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TowZeroSeven {

    /**
     * bfs
     *
     * @param numCourses
     * @param preOption
     * @return
     */
    public boolean canFinish(int numCourses, int[][] preOption) {
        int[] indegrees = new int[numCourses];
        for (int[] cp : preOption) indegrees[cp[0]]++;
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) queue.addLast(i);
        }

        while (!queue.isEmpty()) {
            // 将入度为0 （即学习这门课程没有先决条件）的课程弹出
            Integer course = queue.removeFirst();
            numCourses--;

            // 遍历所有课程,[待学习课程,先决条件课程],找到先决条件可能与弹出课程相同的组合,并将该组合的"待学习课程"的入度自减,如果操作过后该课程入度为0,则加入队列。

            for (int[] req : preOption) {
                if (req[1] != course) continue;
                if (--indegrees[req[0]] == 0) queue.addLast(req[0]);
            }
        }

        return numCourses == 0;

    }
}
