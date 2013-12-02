/**
 * Problem:
 * Given an integer, convert it to a roman numeral.
 *
 * Input is guaranteed to be within the range from 1 to 3999.
 */

/**
 * Algorithm 1:
 * Store all the posible roman numeral for a digit, then replace the the integer.
 */
public class Solution {
    public String intToRoman(int num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.

        String [] thousand = {"", "M", "MM", "MMM"};
        String [] hundred  = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String [] decade   = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String [] unit     = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String [][] romanDigits = {thousand, hundred, decade, unit};

        String romanNumeral = new String();

        int divisor = 1000;
        int number = num;

        for (int i = 0; i < 4; i++) {
            romanNumeral += romanDigits[i][number / divisor];
            number %= divisor;
            divisor /= 10;
        }

        return romanNumeral;
    }
}