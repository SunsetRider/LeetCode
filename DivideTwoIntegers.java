/**
 * Problem:
 * Divide two integers without using multiplication, division and mod operator.
 */

/**
 * Aglorithm 1:
 * Use subtraction.
 * Time Limit Exceeded
 */
public class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int result = -1;
        while (dividend > 0) {
            dividend -= divisor;
            result++;
        }
        
        if ((dividend>0 && divisor>0) || (dividend<0 && divisor<0)) {
            return result;
        }
        return -result;
    }
}
