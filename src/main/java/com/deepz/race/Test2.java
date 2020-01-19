package com.deepz.race;


import com.deepz.linkedlist.week2.ListNode;

import java.util.ArrayList;

class Test2 {

    public static void main(String[] args) {

        Test2 test2 = new Test2();
        test2.printMatrix();

    }

    public ArrayList<Integer> printMatrix(int[][] matrix) {

        ArrayList<Integer> ans = new ArrayList<>();
        int n = matrix.length;
        if (n == 0) return ans;
        int m = matrix[0].length;

        boolean[][] visit = new boolean[m][n];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int x = 0, y = 0, d = 1;

        for (int i = 0; i < n * m; i++) {
            ans.add(matrix[x][y]);
            visit[x][y] = true;
            int a = x + dx[d];
            int b = y + dy[d];
            if (a < 0 || a >= n || b < 0 || b >= m || visit[a][b]) {
                d = (d + 1) % 4;
                a = x + dx[d];
                b = y + dy[d];
            }
            x = a;
            y = b;
        }

        return ans;
    }
}