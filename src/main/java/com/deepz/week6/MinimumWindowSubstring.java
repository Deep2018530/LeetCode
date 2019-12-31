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

    public String minWindow(String s, String t) {

        int[] st = new int[256];        // 用于记录每个字母出现了几次

        int cnt = 0;                    // 总共需要消除的不同字母的个数（因为可能有相同的字母)
        for (int i = 0; i < t.length(); i++) {
            if (st[t.charAt(i)] == 0) {
                cnt++;                      // 这种字母没出现过，那么是“不同的字母",所以”不同的字母“ 个数+1
            }
            st[t.charAt(i)]++;              // 某种字母的出现的次数+1
        }

        String ans = null;
        for (int right = 0, left = 0; right < s.length(); right++) {    // 每次循环都会右移右指针，那么就会 减少右移后的位置上的字母的 "出现的次数"

            if (st[s.charAt(right)] == 1) cnt--;                       // 如果当前字母出现次数为1(稍后会右移，即窗口中会多一个该字母，所以该字母欠下的”出现的次数"会减一)，则减一后等于0，则该字母不欠次数了（说明该字母匹配完毕)
            st[s.charAt(right)]--;

            while (left < s.length() && st[s.charAt(left)] < 0)  st[s.charAt(left++)]++;  // 左指针可以移动的前提是,left位置上的字母出现的次数为负数，代表不欠该字母的“出现的次数"了，即该字母的有无，无关紧要，所以可以右移左指针抛弃该字母。
                                                                                            // 因为抛弃了left位置上的字母，所以该字母所欠下的”出现的次数"需要+1
            if (cnt == 0) {    // 如果没有字母欠“出现的次数”了，代表所有字母都满足了
                if (ans == null || ans.length() > right - left + 1) {    //更新答案，前提是，之前的答案为空，或者之前的答案的长度比现在的长
                    ans = s.substring(left, right + 1);
                }
            }
        }
        return ans == null ? "" : ans;
    }
}
