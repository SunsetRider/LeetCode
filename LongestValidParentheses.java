/**
 * Problem:
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 *
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 *
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */

/**
 * Aglorithm 1:
 * Use a stack to store the position of the left parentheses and use a variable to store the last right parenthesis 
 */
public class Solution {
    public int longestValidParentheses(String s) {
        int result = 0;
        int last = -1;
        Stack<Integer> leftIndex = new Stack<Integer>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftIndex.push(i);
            } else {
                if (leftIndex.isEmpty()) {
                    last = i;
                } else {
                    leftIndex.pop();
                    if (leftIndex.isEmpty()) {
                        result = Math.max(result, i-last);
                    } else {
                        result = Math.max(result, i-leftIndex.peek());
                    }
                }
            }
        }

        return result;
    }
}
