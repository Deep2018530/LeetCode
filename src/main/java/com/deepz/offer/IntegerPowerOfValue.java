package com.deepz.offer;

/**
 * created by zhangdingping on 2020/1/17
 * 数值的整数次方
 */
public class IntegerPowerOfValue {

    public double Power(double base, int exponent) {

        if (exponent == 0) return 1;
        if (exponent == 1) return base;

        boolean flag = exponent < 0 ? true : false;
        if (flag) exponent = Math.abs(exponent);

        double result = Power(base, exponent >> 1);
        result *= result;
        if ((exponent & 1) == 1) result *= base;

        return flag ? 1 / result : result;
    }
}
