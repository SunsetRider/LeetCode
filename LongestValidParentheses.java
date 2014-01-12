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
 * wrong answer
 */
import java.util.Stack;

public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Character> parentheses = new Stack<Character> ();
        int result = 0;
        int lastLength = 0;
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                if (!parentheses.empty()) {
                    if (parentheses.peek() == '(') {
                        lastLength = length;
                        length = 0;
                    }
                }
                parentheses.push(c);
            }

            if (c == ')') {
                if (parentheses.empty()) {
                    if (length > result) {
                        result = length;
                    }
                    length = 0;
                    continue;
                }

                if (parentheses.pop() == '(') {
                    if (parentheses.empty()) {
                        length += lastLength + 2;
                        if (lastLength > result) {
                            result = lastLength;
                        }
                        lastLength = 0;
                    } else {
                        length += 2;
                    }
                }
            }
        }

        if (lastLength > result) {
            result = lastLength;
        }
        if (length > result) {
            result = length;
        }

        return result;
    }
}
