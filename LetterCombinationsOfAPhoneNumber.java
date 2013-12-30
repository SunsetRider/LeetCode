/**
 * Problem:
 * Given a digit string, return all possible letter combinations that the number could represent.
 * 
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */

/**
 * Aglorithm 1:
 * Enumerate all the posible combinations.
 */
public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<String> ();
        String input = digits.replaceAll("[0-1]", "");
        HashMap<Integer, char[]> digitMap = new HashMap<Integer, char[]>();
        digitMap.put(2, new char[]{'a', 'b', 'c'});
        digitMap.put(3, new char[]{'d', 'e', 'f'});
        digitMap.put(4, new char[]{'g', 'h', 'i'});
        digitMap.put(5, new char[]{'j', 'k', 'l'});
        digitMap.put(6, new char[]{'m', 'n', 'o'});
        digitMap.put(7, new char[]{'p', 'q', 'r', 's'});
        digitMap.put(8, new char[]{'t', 'u', 'v'});
        digitMap.put(9, new char[]{'w', 'x', 'y', 'z'});

        int row = 1;
        for (int i = 0; i < input.length(); i++) {
            row *= digitMap.get(input.charAt(i)-'0').length;
        }
        int loopRow = row;
        char[][] output = new char[row][input.length()];
        for (int i = 0; i < input.length(); i++) {
            char[] digitChar = digitMap.get(input.charAt(i)-'0');
            loopRow /= digitChar.length;
            for (int n = 0; n < row/(loopRow*digitChar.length); n++) {
                for (int j = 0; j < digitChar.length; j++) {
                    for (int k = n*(loopRow*digitChar.length)+loopRow*j; k < n*(loopRow*digitChar.length)+loopRow*(j+1); k++) {
                        output[k][i] = digitChar[j];
                    }
                }
            }
        }

        for (int i = 0; i < row; i++) {
            result.add(new String(output[i]));
        }

        return result;
    }
}
