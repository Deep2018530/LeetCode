package com.deepz.week6;

import java.util.Stack;

/**
 * created by zhangdingping on 2020/1/19
 * <p>
 * 接雨水  42  hard
 * <p>
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TrappingRainWater {

    // 单调栈
    public int trap(int[] height) {
        int n = height.length;
        int ans = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            int last = 0;
            while (!stack.isEmpty() && height[stack.peek()] <= height[i]) {
                int top = stack.pop();
                ans += (i - top - 1) * (height[top] - last);
                last = height[top];
            }

            if (!stack.isEmpty()) {
                ans += (i - stack.peek() - 1) * (height[i] - last);
            }
            stack.push(i);
        }

        return ans;
    }
}



