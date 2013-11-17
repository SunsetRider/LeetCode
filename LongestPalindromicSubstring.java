/**
 * Problem:
 * Given a string S, find the longest palindromic substring in S.
 * You may assume that the maximum length of S is 1000,
 * and there exists one unique longest palindromic substring.
 */

/**
 * Algorithm 1:
 * 
 */

public class Solution {
    public String longestPalindrome(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int sLength = s.length();
        if (s == null || sLength == 1)
            return s;

        int middleIndex = sLength/2;
        int shiftIndex;

        int pSubLength = 0;
        String oddPString = new String ();
        for (int i = 0; i < sLength - 2; i++) {
            middleIndex += i * Math.pow(-1, i);
            for (shiftIndex = 1; middleIndex - shiftIndex >= 0 && middleIndex + shiftIndex < sLength; shiftIndex++) {
                if (s.charAt(middleIndex + shiftIndex) == s.charAt(middleIndex - shiftIndex))
                    pSubLength++;
                else
                    break;
            }
            shiftIndex--;

            if (pSubLength * 2 + 1 > oddPString.length() && pSubLength != 0) {
                oddPString = s.substring(middleIndex - shiftIndex, middleIndex + shiftIndex + 1);
                if ((sLength/2-Math.abs(sLength/2-(middleIndex+(i+1)*Math.pow(-1, i+1)))*2+1) <= oddPString.length())
                    break;
            }
        }

        return oddPString;
    }
}