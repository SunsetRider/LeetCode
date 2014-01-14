/**
 * Problem:
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 *
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 */

/**
 * Aglorithm 1:
 * Check row, column and 3x3 cube.
 * If there's duplicated character, return false.
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> num = new HashSet<Character>();
        
        // check row
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (num.contains(c)) {
                        return false;
                    } else {
                        num.add(c);
                    }
                }    
            }
            num.clear();
        }
        
        // check column
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[j][i];
                if (c != '.') {
                    if (num.contains(c)) {
                        return false;
                    } else {
                        num.add(c);
                    }
                }    
            }
            num.clear();
        }
        
        // check 3x3 cube
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int m = 0; m < 3; m++) {
                    for (int n = 0; n < 3; n++) {
                        char c = board[i*3+m][j*3+n];
                        if (c != '.') {
                            if (num.contains(c)) {
                                return false;
                            } else {
                                num.add(c);
                            }
                        }
                    }
                }
                num.clear();
            }
        }
        
        return true;
    }
}
