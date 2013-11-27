/**
 * Problem:
 * Implement regular expression matching with support for '.' and '*'.
 * 
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * 
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 */

/**
 * Algorithm 1:
 * 
 */
public class Solution {

    boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            // throw an exception
        }

        boolean result = isMatch(s, p, 0, 0);

        return result;
    }

    boolean isMatch(String s, String p, int sIndex, int pIndex) {
        if (pIndex == p.length()) {
            return sIndex == s.length();
        }

        // next char is not '*': must match current character
        if (pIndex+1 < p.length()) {
            if (p.charAt(pIndex+1) != '*') {
                if (p.charAt(pIndex) == '*') {
                    // throw an exception
                }

                return (p.charAt(pIndex) == s.charAt(sIndex) || (p.charAt(pIndex) == '.' && sIndex != s.length())
                        && isMatch(s, p, sIndex+1, pIndex+1));
            }
        } else {
            if (p.charAt(pIndex) == '*') {
                // throw an exception
            }
            return (p.charAt(pIndex) == s.charAt(sIndex) || (p.charAt(pIndex) == '.' && sIndex != s.length())
                    && isMatch(s, p, sIndex+1, pIndex+1));
        }
        // next char is '*'
        while (p.charAt(pIndex) == s.charAt(sIndex) || (p.charAt(pIndex) == '.' && sIndex != s.length())) {
            if (isMatch(s, p, sIndex, pIndex+2)) {
                return true;
            }
            sIndex++;
        }


        return isMatch(s, p, sIndex, pIndex + 2);
    }
}
