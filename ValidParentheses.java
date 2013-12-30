/**
 * Problem:
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */

/**
 * Aglorithm 1:
 * Use a hashmap to store the relation of parentheses and Use a stack to check the string.
 */
import java.util.HashMap;
import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> pMap = new HashMap<Character, Character>();
        pMap.put('(', ')');
        pMap.put('[', ']');
        pMap.put('{', '}');

        Stack<Character> pStack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (pMap.containsKey(c)) {
                pStack.push(c);
            } else if (pStack.isEmpty()) {
                return false;
            } else if (pMap.get(pStack.pop()) != c) {
               return false;
            }
        }

        if (pStack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
