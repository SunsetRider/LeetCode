/**
 * Problem:
 * Given a roman numeral, convert it to an integer.
 *
 * Input is guaranteed to be within the range from 1 to 3999.
 */

/**
 * Algorithm 1:
 * Read each char of the string:
 * if its numeral value is smaller than the next char, decrease the value;
 * else increase the value.
 */
public class Solution {
    public int romanToInt(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.

        String romanOrder = "IVXLCDM";

        HashMap<Character, Integer> romanMap = new HashMap<Character, Integer>();
        romanMap.put('M', 1000);
        romanMap.put('D', 500);
        romanMap.put('C', 100);
        romanMap.put('L', 50);
        romanMap.put('X', 10);
        romanMap.put('V', 5);
        romanMap.put('I', 1);

        int result = 0;

        for (int i = 0; i < s.length()-1; i++) {
            char c = s.charAt(i);
            if (romanOrder.indexOf(c) < romanOrder.indexOf(s.charAt(i+1))) {
                result -= romanMap.get(c);
            } else {
                result += romanMap.get(c);
            }
        }

        result += romanMap.get(s.charAt(s.length()-1));

        return result;

    }
}
