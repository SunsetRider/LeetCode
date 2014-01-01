/**
 * Problem:
 * Implement strStr().
 * 
 * Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.
 */

/**
 * Aglorithm 1:
 * Straightforward.
 */
public class Solution {
    public String strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return null;
        }
        if (needle.length() == 0) {
            return haystack;
        }


        boolean equal = true;
        for (int i = 0; i <= haystack.length()-needle.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                for (int j = 0; j < needle.length(); j++) {
                    if (haystack.charAt(j+i) != needle.charAt(j)) {
                        equal = false;
                        break;
                    }
                }

                if (equal) {
                    return haystack.substring(i);
                } else {
                    equal = true;
                }
            }
        }

        return null;
    }
}
