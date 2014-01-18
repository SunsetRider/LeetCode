/**
 * Problem:
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * 
 * Note: The sequence of integers will be represented as a string.
 */

/**
 * Aglorithm 1:
 * Time Limit Exceeded
 */
public class Solution {
    public String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }

        StringBuilder result = new StringBuilder ("1");
        int num;
        char lastDigit;
        for (int i = 1; i < n; i++) {
            lastDigit = result.charAt(0);
            num = 0;
            int times = result.length();
            for (int j = 0; j < times; j++) {
                char c = result.charAt(0);
                result.deleteCharAt(0);
                if (c == lastDigit) {
                    num++;
                } else {
                    result.append(num);
                    result.append(lastDigit);

                    lastDigit = c;
                }
            }

            if (num != 0) {
                result.append(num);
                result.append(lastDigit);
            }
        }

        return result.toString();
    }
}
