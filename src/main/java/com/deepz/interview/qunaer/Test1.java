package com.deepz.interview.qunaer;

import java.util.*;

/**
 * created by zhangdingping at 2019/10/16
 * 去哪儿 2018校招 第六批次 第一题  AC 80%
 * 错误案例 ： LSWEWS MEWLME   true
 * 给定两个均由大写英文字母组成的字符串（A-Z），检查这两个字符串是否仅包含相同的字母
 */
public class Test1 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> strs = new ArrayList<>();
        //List<Boolean> ans = new ArrayList<>();
        while (sc.hasNext()) {
            strs.add(sc.nextLine());
        }
        for (String str : strs) {
            String[] s = str.split(" ");
            sb.append(judge(s[0], s[1])).append(System.lineSeparator());
        }
        System.out.println(sb.toString());
    }

    private static Boolean judge(String s1, String s2) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s1.length(); i++) {
            set.add(s1.charAt(i));
        }
        int size = set.size();

        for (int i = 0; i < s2.length(); i++) {
            set.add(s2.charAt(i));
        }
        if (set.size() > size) {
            return false;
        } else {
            return true;
        }
    }
}
