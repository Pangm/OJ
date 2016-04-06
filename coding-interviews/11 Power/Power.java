// 数值的整数次方
// 题目描述

// 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。

public class Solution {
    public double Power(double base, int exponent) {
        double result = 1;
        if (base == 0) {
            // impossible
            if (exponent == 0) {
                return result;
            } else {
            	return 0;
            }
        }
        boolean isNegative = false;
        if (exponent < 0) {
            isNegative = true;
        }
        
        result = PowerWithUnsigned(base, Math.abs(exponent));
        
       	return isNegative ? (1.0 / result) : result;
    }
    
    public double PowerWithUnsigned(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        
        if (exponent == 1) {
            return base;
        }

        double result = PowerWithUnsigned(base, exponent >> 1);
        result *= result;

        if ((exponent & 0x1) == 1) {
            result *= base;
        }

        return result;
  	}
    
    public double PowerWithUnsignedNative(double base, int exponent) {
        double result = 1.0;
        for (int i = 0; i < exponent; ++i) {
            result *= base;
        }
        
        return result;
    }
    
}