/**
 * Reverse digits of an integer.
 *
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 *
 * click to show spoilers.
 *
 * Have you thought about this?
 * Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!
 *
 * If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.
 *
 * Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?
 *
 * Throw an exception? Good, but what if throwing an exception is not an option? You would then have to re-design the function (ie, add an extra parameter).
 */

/**
 * Algorithm 1:
 * 1.Convert the integer to string;
 * 2.Reverse the string;
 * 3.Convert the string to integer.
 */
public class Solution {
    public int reverse(int x) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.

        int rvsInt = 0;
        StringBuilder xString = new StringBuilder(new Integer(x).toString());
        if (xString.charAt(0) == '-') {
            xString.deleteCharAt(0);
            xString.append('-');
        }

        rvsInt = Integer.parseInt(xString.reverse().toString());

        return rvsInt;
    }
}

/**
 * Algorithm 2:
 * No need to convert the integer to string.
 */
public class Solution {
    public int reverse(int num) {
        int rev = 0;
        while (num != 0) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        
        return rev;
    }
}


