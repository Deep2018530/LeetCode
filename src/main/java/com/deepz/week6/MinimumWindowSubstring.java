package com.deepz.week6;

import com.sun.java.swing.plaf.windows.resources.windows;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 76
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 * <p>
 * 示例：
 * <p>
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * <p>
 * 说明：
 * <p>
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinimumWindowSubstring {

    public static String minWindow(String s, String t) {

        int left = 0;
        int right = 0;

        int tLen = t.length();

        String minWindow;
        while (right < s.length() && tLen-- > 0) {
            right++;
        }
        if (tLen > 0) return "";

        boolean flag = false;
        minWindow = s.substring(left, right);
        String temp = minWindow;
        while (true) {
            if (check(temp, t)) {
                flag = true;
                minWindow = temp;
                left++;
                if (left > s.length()) break;
                temp = s.substring(left, right);
            } else {
                right++;
                if (right > s.length()) break;
                temp = s.substring(left, right);
            }
        }
        return !flag ? "" : minWindow;
    }

    private static boolean check(String window, String t) {
        if (t.length() > window.length()) return false;

        List<Character> windows = new ArrayList<>();
        for (int i = 0; i < window.length(); i++) {
            windows.add(window.charAt(i));
        }

        List<Character> ts = new ArrayList<>();
        for (int i = 0; i < t.length(); i++) {
            ts.add(t.charAt(i));
        }

        for (int i = 0; i < ts.size(); i++) {
            for (int j = 0; j < windows.size(); j++) {
                if (ts.get(i).equals(windows.get(j))) {
                    windows.remove(j);
                    j = -1;
                }
            }
        }
        return window.length() == windows.size() + ts.size();

    }

    public static void main(String[] args) {
        String a = "cabwefgewcwaefgcf";
        String b = "cae";
        System.out.println(minWindow(a, b));
    }
}
