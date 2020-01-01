package com.deepz.week6;

/**
 * 32
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * <p>
 * 示例 2:
 * <p>
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestValidPaentheses {


    public int longestValidParentheses(String s) {

        int ans = 0;
        for (int i = 0, temp = 0; i < s.length() + 1; i++) {
            if (check(s, i, i + 1)) {
                temp += 2;
                i++;
            } else {
                ans = temp > ans ? temp : ans;
                temp = 0;
            }
        }
        return ans;
    }

    private boolean check(String s, int p, int q) {
        if (p >= s.length() || q >= s.length()) return false;

        if (s.charAt(p) == '(' && s.charAt(q) == ')') return true;
        return false;
    }

    public static void main(String[] args) {
        longestValidParentheses("()(())");
    }
}
