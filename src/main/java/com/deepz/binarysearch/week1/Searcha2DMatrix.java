package com.deepz.binarysearch.week1;

/**
 * created by zhangdingping on 2019/8/19
 * 题号：74
 */
public class Searcha2DMatrix {


    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix.length == 0 || matrix[0].length == 0) return false;

        int n = matrix.length, m = matrix[0].length;
        int l = 0, r = n * m - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (matrix[mid / m][mid % m] >= target) r = mid;
            else l = mid + 1;
        }

        if (matrix[r / m][r % m] != target) return false;
        return true;

    }

}
