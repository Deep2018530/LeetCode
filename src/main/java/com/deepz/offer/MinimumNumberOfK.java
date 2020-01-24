package com.deepz.offer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * created by zhangdingping on 2020/1/24
 * 最小的k个数
 */
public class MinimumNumberOfK {

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (input == null || input.length == 0 || input.length < k || k == 0) return new ArrayList<>();

        PriorityQueue<Integer> bigHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int num : input) {
            if (bigHeap.size() < k) bigHeap.add(num);
            else if (num < bigHeap.peek()) {
                bigHeap.poll();
                bigHeap.add(num);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        while (!bigHeap.isEmpty()) res.add(bigHeap.poll());

        return res;
    }
}
