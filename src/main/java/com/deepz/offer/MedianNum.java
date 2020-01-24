package com.deepz.offer;

import java.util.PriorityQueue;

/**
 * created by zhangdingping on 2020/1/24
 * 数据流中的中位数
 */
public class MedianNum {

    PriorityQueue<Integer> min = new PriorityQueue<>();
    PriorityQueue<Integer> max = new PriorityQueue<>((a, b) -> b - a);

    public void Insert(Integer num) {
        max.add(num);
        min.add(max.poll());
        if (min.size() > max.size()) max.add(min.poll());
    }

    public Double GetMedian() {
        if (min.size() == max.size()) return (max.peek() + min.poll()) / 2.0;
        return (double) max.peek();
    }
}
