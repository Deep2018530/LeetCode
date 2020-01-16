package com.deepz.race;

import com.deepz.linkedlist.week2.ListNode;

import java.util.*;


class Test2 {

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        System.out.println(test2.movingCount(5, 10, 10));
    }

    public int movingCount(int threshold, int rows, int cols) {
        int ans = 0;
        if (rows <= 0 || cols <= 0) return 0;

        Deque<int[]> queue = new ArrayDeque<>();
        boolean[][] visit = new boolean[rows][cols];

        queue.push(new int[]{0, 0});

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            int[] top = queue.peek();
            queue.poll();

            if (get_sum(top) > threshold || visit[top[0]][top[1]]) continue;
            ans++;
            visit[top[0]][top[1]] = true;

            for (int i = 0; i < 4; i++) {
                int x = dx[i] + top[0], y = dy[i] + top[1];
                if (x >= 0 && x < rows && y >= 0 && y < cols)
                    queue.push(new int[]{x, y});
            }
        }

        return ans;
    }

    private int get_sum(int[] top) {
        return get_single_sum(top[0]) + get_single_sum(top[1]);
    }

    private int get_single_sum(int num) {

        int res = 0;
        while (num != 0) {
            res += num % 10;
            num /= 10;
        }

        return res;
    }


}