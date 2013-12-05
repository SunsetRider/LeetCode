/**
 * Problem:
 * Write a function to find the longest common prefix string amongst an array of strings.
 */

/**
 * Algorithm 1:
 * 1.Set the first string as the result;
 * 2.Compare the result string with every other sting in the array;
 * 3.In every comparison assign the common prefix string to result string.
 * 
 * Note:
 * 1.The length of string array may be 0;
 * 2.The length of the first string in the array may be 0;
 * 3.The length of the rest strings of the array may be 0;
 * 4.The common prefix string may be "" in every comparison.
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs[0].length() == 0) {
            return "";
        }

        String result = strs[0];

        for (int is = 1; is < strs.length; is++) {
            if (strs[is].length() == 0) {
                return "";
            }

            for (int ic = 0; ic < strs[is].length() && ic < result.length(); ic++) {
                if (result.charAt(ic) != strs[is].charAt(ic)) {
                    if (ic == 0) {
                        return "";
                    }
                    result = strs[is].substring(0, ic);
                } else if (ic == strs[is].length()-1) {
                    result = strs[is];
                }
            }
        }

        return result;
    }
}

