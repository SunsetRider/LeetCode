/**
 * Implement atoi to convert a string to an integer.
 *
 * Hint: Carefully consider all possible input cases. 
 * If you want a challenge, please do not see below and ask yourself 
 * what are the possible input cases.
 *
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). 
 * You are responsible to gather all the input requirements up front.
 *
 * spoilers alert...
 *
 * Requirements for atoi:
 * The function first discards as many whitespace characters as necessary
 * until the first non-whitespace character is found. 
 * Then, starting from this character, takes an optional initial plus 
 * or minus sign followed by as many numerical digits as possible,
 * and interprets them as a numerical value.
 *
 * The string can contain additional characters after those that form the integral number,
 * which are ignored and have no effect on the behavior of this function.
 *
 * If the first sequence of non-whitespace characters in str is not a valid integral number,
 * or if no such sequence exists because either str is empty or it contains only whitespace characters,
 * no conversion is performed.
 *
 * If no valid conversion could be performed, a zero value is returned.
 * If the correct value is out of the range of representable values,
 * INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 */

/**
 * Algorithm 1:
 * Follow the requirements above.
 */

public class Solution {
    public int atoi(String str) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (str == null)
            return 0;

        int result = 0;
        boolean negative = false;
        boolean sign = false;
        boolean digit = false;
        int digitStartIndex = 0;
        int signStartIndex = 0;


        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                digitStartIndex = i;
                digit = true;
                break;
            }

            if (str.charAt(i) == '-') {
                negative = true;
                sign = true;
                signStartIndex = i;
                break;
            } else if (str.charAt(i) == '+') {
                sign = true;
                signStartIndex = i;
                break;
            }

            if (str.charAt(i) == ' ') {
                continue;
            } else if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                return 0;
            }
        }

        if (!digit && !sign) {
            return 0;
        } else if (sign) {
            digitStartIndex = signStartIndex + 1;
        }

        int intLength = 0;
        for (int i = 0; i + digitStartIndex < str.length(); i++) {
            if (str.charAt(i+digitStartIndex) >= '0' && str.charAt(i+digitStartIndex) <= '9') {
                intLength++;
            } else {
                break;
            }
        }

        for (int i = 0; i < intLength; i++) {
            if (negative) {
                if (result - (int)(str.charAt(i+digitStartIndex)-'0')*Math.pow(10, intLength-1-i) >= Integer.MIN_VALUE)
                    result -= (int)(str.charAt(i+digitStartIndex)-'0')*Math.pow(10, intLength-1-i);
                else
                    return Integer.MIN_VALUE;
            } else {
                if (result + (int)(str.charAt(i+digitStartIndex)-'0')*Math.pow(10, intLength-1-i) <= Integer.MAX_VALUE)
                    result += (int)(str.charAt(i+digitStartIndex)-'0')*Math.pow(10, intLength-1-i);
                else
                    return Integer.MAX_VALUE;
            }
        }

        return result;
    }
}
