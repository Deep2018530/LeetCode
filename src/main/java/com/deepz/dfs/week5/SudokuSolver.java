package com.deepz.dfs.week5;

/**
 * created by zhangdingping at 2019/12/24
 * <p>
 * <p>
 * 37
 * <p>
 * 编写一个程序，通过已填充的空格来解决数独问题。
 * <p>
 * 一个数独的解法需遵循如下规则：
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 */
public class SudokuSolver {


    public void solveSudoku(char[][] board) {
        char[][] table = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                table[i][j] = board[i][j];
            }
        }
        dfs(table, board, 0, 0);
    }

    private void dfs(char[][] ans, char[][] board, int x, int y) {

        if (x == 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    board[i][j] = ans[i][j];
                }
            }
            return;
        }

        if (ans[x][y] == '.') {
            for (int num = 1; num < 10; num++) {
                if (check(ans, x, y, num)) {
                    ans[x][y] = (char) ('0' + num);
                    dfs(ans, board, x + (y + 1) / 9, (y + 1) % 9);
                }
            }
            ans[x][y] = '.';
        } else {
            dfs(ans, board, x + (y + 1) / 9, (y + 1) % 9);
        }

    }

    private boolean check(char[][] board, int x, int y, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[x][i] == (char) ('0' + num)) return false;
            if (board[i][y] == (char) ('0' + num)) return false;
        }

        for (int i = (x / 3) * 3; i < (x / 3 + 1) * 3; i++) {
            for (int j = (y / 3) * 3; j < (y / 3 + 1) * 3; j++) {
                if (board[i][j] == (char) ('0' + num)) return false;
            }
        }
        return true;
    }

}
