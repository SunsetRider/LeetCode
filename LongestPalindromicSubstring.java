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
        if (sLength == 2 && s.charAt(0) == s.charAt(1))
            return s;

        String oddPString = new String ();
        String evenPString = new String ();

        int middleIndex;
        int shiftIndex;
        int pSubLength;

        // palindromic substring's length is odd
        middleIndex = sLength/2;
        for (int i = 0; i < sLength - 2; i++) {
            middleIndex += i * Math.pow(-1, i);
            pSubLength = 0;

            for (shiftIndex = 1; middleIndex - shiftIndex >= 0 && middleIndex + shiftIndex < sLength; shiftIndex++) {
                if (s.charAt(middleIndex + shiftIndex) == s.charAt(middleIndex - shiftIndex))
                    pSubLength++;
                else
                    break;
            }
            shiftIndex--;

            if (pSubLength * 2 + 1 > oddPString.length() && pSubLength != 0)
                oddPString = s.substring(middleIndex - shiftIndex, middleIndex + shiftIndex + 1);

            if (middleIndex < sLength/2 && (middleIndex*2+1) <= oddPString.length())
                break;
            if (middleIndex > sLength/2 && (sLength-middleIndex)*2-1 <= oddPString.length())
                break;
        }

        // palindromic substring's length is even
        middleIndex = sLength/2;
        for (int i = 0; i < sLength; i++) {
            middleIndex += i * Math.pow(-1, i);
            pSubLength = 0;

            for (shiftIndex = 0; middleIndex - shiftIndex - 1 >= 0 && middleIndex + shiftIndex < sLength; shiftIndex++) {
                if (s.charAt(middleIndex + shiftIndex) == s.charAt(middleIndex - 1 - shiftIndex))
                    pSubLength++;
                else
                    break;
            }
            shiftIndex--;

            if (pSubLength * 2 > evenPString.length() && pSubLength != 0)
                evenPString = s.substring(middleIndex - 1 - shiftIndex, middleIndex + shiftIndex + 1);

            if (middleIndex < sLength/2 && (middleIndex*2+2) == evenPString.length())
                break;
            if (middleIndex > sLength/2 && (sLength-middleIndex)*2 == evenPString.length())
                break;
        }

        if (oddPString.length() > evenPString.length())
            return oddPString;
        else
            return evenPString;
    }
}
