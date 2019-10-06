package com.deepz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * created by zhangdingping on 2019/8/26
 */
public class Test1 {

    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        n--;
        while (n > 0) {
            StringBuilder sbTemp = new StringBuilder();
            for (int i = 0, len = sb.length(); i < len; i++) {
                int j = i;
                int count = 0;
                while (j < len && sb.charAt(j) == sb.charAt(i)) {
                    j++;
                    count++;
                }
                i = j - 1;
                sbTemp.append(count).append(sb.charAt(i));
            }
            n--;
            sb = sbTemp;
        }


        return sb.toString();
    }

}
