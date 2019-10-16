package com.deepz.interview.qunaer;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * created by zhangdingping at 2019/10/16
 * <p>
 * 去哪儿 2018校招 第六批次 第二题
 * 给定一个数字，获取大于此数字的下一个数字X，要求X为对称数字
 */
public class Test2 {

    static StringBuilder ans = new StringBuilder();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<String> strs = new ArrayList<>();
        while (sc.hasNext()) {
            strs.add(sc.nextLine());
        }

        for (String str : strs) {
            ans.append(judge(str)).append(System.lineSeparator());
        }

        System.out.println(ans.toString());
    }

    private static long judge(String str) {
        int len = str.length();
        if (len == 1) {
            return Long.valueOf(str) + 1;
        }
        return 0;
    }

}
