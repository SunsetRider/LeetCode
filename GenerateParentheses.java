/**
 * Problem:
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 */

/**
 * Aglorithm 1:
 * Use recursion.
 */
import java.util.ArrayList;

public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        if (n < 1) {
            return null;
        }

        ArrayList<String> result = new ArrayList<String>();
        getPStrings(result, new String(), n, n);

        return result;

    }

    public void getPStrings(ArrayList<String> result, String parentheses, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(parentheses);
            return;
        }
         
        if (left == right) {
            // parentheses always start with a left parenthesis
            getPStrings(result, parentheses.concat("("), left-1, right);
        } else {
            if (left != 0) {
                getPStrings(result, parentheses.concat("("), left-1, right);
            }
            if (right != 0) {
                getPStrings(result, parentheses.concat(")"), left, right-1);
            }
        }
    }
}
