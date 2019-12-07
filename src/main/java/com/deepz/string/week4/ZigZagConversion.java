package com.deepz.string.week4;

/**
 * created by zhangdingping on 2019/12/7
 * 6
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * <p>
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 */
public class ZigZagConversion {

    public String convert(String s, int n) {
        if (n == 1) return s;

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i == 0 || i == n - 1) {
                for (int j = i; j < s.length(); j += 2 * (n - 1)) res.append(s.charAt(j));
            } else {
                for (int j = i, k = 2 * (n - 1) - i; j < s.length() || k < s.length(); j += 2 * (n - 1), k += 2 * (n - 1)) {
                    if (j < s.length()) res.append(s.charAt(j));
                    if (k < s.length()) res.append(s.charAt(k));
                }
            }
        }
        return res.toString();
    }
}
