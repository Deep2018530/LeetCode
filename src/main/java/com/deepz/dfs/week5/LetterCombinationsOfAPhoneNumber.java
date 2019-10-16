package com.deepz.dfs.week5;

import java.util.LinkedList;
import java.util.List;

/**
 * created by zhangdingping on 2019/10/9
 * 17 电话号码的字母组合
 */
public class LetterCombinationsOfAPhoneNumber {
    public static List<String> letterCombinations(String digits) {
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        LinkedList<String> ans = new LinkedList<>();
        if (!digits.isEmpty()) {
            ans.add("");

            for (int i = 0, len = digits.length(); i < len; i++) {
                int x = Character.getNumericValue(digits.charAt(i));
                while (ans.peek().length() == i) {
                    String temp = ans.remove();
                    for (char s : mapping[x].toCharArray()) {
                        ans.add(temp + s);
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        letterCombinations("2321");
    }
}
