package com.deepz.binarysearch.week1;

/**
 * created by zhangdingping on 2019/8/21
 * 题号:278
 */
public class FirstBadVersion {

    public int firstBadVersion(int n) {

        int l = 1, r = n;

        while (l < r) {
            int mid = l + (r - l) / 2; // 用 l + r >> 1 会返回  “超出时间限制”
            if (isBadVersion(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    private boolean isBadVersion(int version) {
        return true;
    }
}
