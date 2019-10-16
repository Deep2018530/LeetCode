package com.deepz.interview.qunaer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * created by zhangdingping at 2019/10/16
 * 去哪儿 校招 2018 第六批次 第三题
 * <p>
 * AC 100
 * 身份证号找生日
 */
public class Test3 {

    static StringBuilder ans = new StringBuilder();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<String> inputs = new ArrayList<>();
        while (sc.hasNext()) {
            inputs.add(sc.nextLine());
        }

        for (String input : inputs) {
            judge(input);
        }

        System.out.println(ans.toString());

    }

    private static void judge(String input) {
        if (input.length() != 18) {
            ans.append("ERROR").append(System.lineSeparator());
            return;
        }
        ans.append(input.substring(6, 14)).append(System.lineSeparator());
    }
}
