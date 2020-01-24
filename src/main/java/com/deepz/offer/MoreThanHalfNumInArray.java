package com.deepz.offer;

/**
 * created by zhangdingping on 2020/1/24
 * 数组中超过一半的数
 */
public class MoreThanHalfNumInArray {

    public int MoreThanHalfNum_Solution(int[] array) {
        if (array.length == 0) return 0;

        int result = array[0];
        int times = 1;
        for (int i = 1; i < array.length; i++) {
            if (times == 0) {
                result = array[i];
                times++;
            } else if (array[i] == result) times++;
            else times--;
        }

        if (times != 0) {
            times = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] == result) times++;
            }
            if (times * 2 > array.length) return result;
        }
        return 0;

    }
}
