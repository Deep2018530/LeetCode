package com.deepz.string.week4;

/**
 * created by zhangdingping on 2019/10/6
 * 151 翻转字符串里的单词
 */
public class ReverseWordsInAString {

    private static final char NULL_CHAR = ' ';

    public String reverseWords(String s) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0, len = s.length(); i < len; i++) {
            while (i < len && s.charAt(i) == NULL_CHAR) i++;
            if (i == s.length()) break;
            int begin = i;
            while (i < len && s.charAt(i) != NULL_CHAR) i++;
            i--;
            int end = i;
            while (end >= begin) {
                sb.append(s.charAt(end));
                end--;
            }
            sb.append(" ");
        }

        return new StringBuilder(sb.toString().trim()).reverse().toString();
    }
}
