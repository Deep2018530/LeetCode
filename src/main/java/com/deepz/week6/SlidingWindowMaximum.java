package com.deepz.week6;

import java.util.*;

/**
 * created by zhangdingping on 2020/1/27
 * <p>
 * 289 滑动窗口最大值
 */
public class SlidingWindowMaximum {

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < num.length; i++) {
            if (!q.isEmpty() && i - size + 1 > q.peek()) q.poll();
            while (!q.isEmpty() && num[q.peekLast()] <= num[i]) q.pollLast();
            q.addLast(i);

            if (i >= size - 1) ans.add(num[q.peek()]);
        }

        return ans;
    }
}
