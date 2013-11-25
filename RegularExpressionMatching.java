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
    public boolean isMatch(String s, String p) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (s == null) {
            if (p == ".*" || p == null)
                return true;
            else 
                return false;
        }
            
        int pi = 0;
        StringBuilder pb = new StringBuilder (p);
        for (int si = 0; si < s.length(); si++) {
            if (pi >= pb.length()) {
                return false;
            }
            
            if (s.charAt(si) == pb.charAt(pi)) {
                pi++;
            } else if (pb.charAt(pi) == '.') {
                pb.setCharAt(pi, s.charAt(si));
                pi++;
            } else if (pb.charAt(pi) == '*') {
                if (pi-1 >= 0) {
                    if (pb.charAt(pi-1) == s.charAt(si))
                        continue;
                } else {
                    return false;
                }
            } else if (pi+1 < pb.length()) {
                if (pb.charAt(pi+1) == '*') {
                    pi++;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        
        // judge whether p still has chars that are not in s
        if (pi == pb.length()-1) {
            if (pb.charAt(pi) == '*') {
                return true;
            } else {
                return false;
            }
        } else if (pi == pb.length()) {
            return true;
        } else {
            return false;
        }
        
    }
}
