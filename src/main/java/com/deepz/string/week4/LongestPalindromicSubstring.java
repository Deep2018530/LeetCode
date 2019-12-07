package com.deepz.string.week4;

/**
 * created by zhangdingping on 2019/12/7
 * 5
 * <p>
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {

        String res = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i, k = i; j >= 0 && k < s.length() && s.charAt(j) == (s.charAt(k)); j--, k++) {
                if (res.length() < k - j + 1) res = s.substring(j, k + 1);
            }

            for (int j = i, k = i + 1; j >= 0 && k < s.length() && s.charAt(j) == (s.charAt(k)); j--, k++) {
                if (res.length() < k - j + 1) res = s.substring(j, k + 1);
            }
        }

        return res;
    }
}
