package com.deepz.string.week4;

/**
 * created by zhangdingping at 2019/11/5
 * 165 比较版本号
 */
public class CompareVersionNumbers {

    public static int compareVersion(String v1, String v2) {

        int i = 0, j = 0;
        while (i < v1.length() || j < v2.length()) {
            int x = i, y = j;

            while(x < v1.length() && v1.charAt(x) != '.') x++;
            while(y < v2.length() && v2.charAt(y) != '.') y++;

            System.out.println(i + "\t" + x + "\t" +v1.length());

            int i1 = i == x ? 0 : Integer.parseInt(v1.substring(i, x));
            int i2 = j == y ? 0 : Integer.parseInt(v2.substring(j, y));

            if (i1 > i2) return  1;
            if (i1 < i2) return -1;
            i = x + 1;
            j = y + 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        compareVersion("1.0", "1.1");
    }
}
