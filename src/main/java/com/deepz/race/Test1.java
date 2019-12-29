package com.deepz.race;

import com.deepz.string.week4.Trie;

import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.*;

/**
 * created by zhangdingping on 2019/12/29
 */
public class Test1 {

    String[] words;
    String result;
    boolean flag;
    Map<Character, Integer> map = new HashMap<>();
    boolean st[] = new boolean[10];


    public boolean isSolvable(String[] words, String result) {
        this.words = words;
        this.result = result;

        Set<Character> set = new HashSet<>();
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                set.add(word.charAt(i));
            }
        }

        for (int i = 0; i < result.length(); i++) {
            set.add(result.charAt(i));
        }

        Object[] sets = set.toArray();
        dfs(sets, 0);

        return flag;
    }

    private void dfs(Object[] sets, int k) {
        if (k >= sets.length) {
            if (check()) {
                flag = true;
                return;
            } else {
                return;
            }
        }

        for (int i = k; i < sets.length; i++) {
            Character character = (Character) sets[i];
            for (int j = 0; j < 10; j++) {
                if (!st[j]) {
                    map.put(character, j);
                    st[j] = true;
                    dfs(sets, k + 1);
                    map.remove(character);
                    st[j] = false;
                }
            }
        }


    }

    private boolean check() {

        List<Integer> nums = new ArrayList<>();
        Integer result = Integer.valueOf(0);
        for (String word : words) {
            Integer num = Integer.valueOf(0);
            for (int i = 0; i < word.length(); i++) {
                char at = word.charAt(i);
                Integer value = map.get(at);
                num = num * 10 + value;
            }
            nums.add(num);
        }

        for (int i = 0; i < this.result.length(); i++) {
            char at = this.result.charAt(i);
            Integer value = map.get(at);
            result = result * 10 + value;
        }

        for (Integer num : nums) {
            result -= num;
        }

        return result == 0;
    }
}
