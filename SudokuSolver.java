/**
 * Problem:
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 *
 * Empty cells are indicated by the character '.'.
 *
 * You may assume that there will be only one unique solution.
 */

/**
 * Aglorithm 1:
 * Runtime Error
 */
import java.util.ArrayList;

public class Solution {
    public void solveSudoku(char[][] board) {
        ArrayList<Character> digitList = new ArrayList<Character> ();
        digitList.add('1');
        digitList.add('2');
        digitList.add('3');
        digitList.add('4');
        digitList.add('5');
        digitList.add('6');
        digitList.add('7');
        digitList.add('8');
        digitList.add('9');
        boolean[][][] canBeFilled = new boolean[9][9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                for (int k = 0; k < 9; k++) {
                    canBeFilled[i][j][k] = true;
                }
            }
        }

        // initialize
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++){
                if (board[i][j] != '.') {
                    changeCanBeFilled (canBeFilled, board[i][j], i, j);
                }
            }
        }

        while (digitList.size() != 0) {
            for (int i = 0; i < digitList.size(); i++) {
                char digit = digitList.get(i);
                fillDigit(board, canBeFilled, digit);
                if (!need(canBeFilled, digit)) {
                    digitList.remove(i);
                    break;
                }
            }
        }

        System.out.print("hello");
    }

    public void changeCanBeFilled (boolean[][][] canBeFilled, char digit, int row, int column) {
        int d = digit - '1';
        for (int i = 0; i < 9; i++) {
            canBeFilled[i][row][column] = false;
        }

        for (int i = 0; i < 9; i++) {
            canBeFilled[d][row][i] = false;
            canBeFilled[d][i][column] = false;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                canBeFilled[d][row/3*3+i][column/3*3+j] = false;
            }
        }
    }

    public void fillDigit(char[][] board, boolean[][][] canBeFilled, char digit) {
        int d = digit - '1';
        int num;
        int row;
        int column;

        for (int i = 0; i < 9; i++) {
            num = 0;
            row = 0;
            column = 0;
            for (int j = 0; j < 9; j++) {
                if (canBeFilled[d][i][j]) {
                    num++;
                    row = i;
                    column = j;
                }
            }
            if (num == 1) {
                board[row][column] = digit;
                changeCanBeFilled (canBeFilled, digit, row, column);
            }
        }

        for (int i = 0; i < 9; i++) {
            num = 0;
            row = 0;
            column = 0;
            for (int j = 0; j < 9; j++) {
                if (canBeFilled[d][j][i]) {
                    num++;
                    row = j;
                    column = i;
                }
            }
            if (num == 1) {
                board[row][column] = digit;
                changeCanBeFilled (canBeFilled, digit, row, column);
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                num = 0;
                row = 0;
                column = 0;
                for (int m = 0; m < 3; m++) {
                    for (int n = 0; n < 3; n++) {
                        if (canBeFilled[d][i*3+m][j*3+n]) {
                            num++;
                            row = i*3+m;
                            column = j*3+n;
                        }
                    }
                }
                if (num == 1) {
                    board[row][column] = digit;
                    changeCanBeFilled (canBeFilled, digit, row, column);
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                num = 0;
                row = 0;
                column = 0;
                char c = '.';
                for (int k = 0; k < 9; k++) {
                    if (canBeFilled[k][i][j]) {
                        num++;
                        row = i;
                        column = j;
                        c = (char) (k+'1');
                    }
                }
                if (num == 1) {
                    board[row][column] = c;
                    changeCanBeFilled (canBeFilled, c, row, column);
                }
            }
        }
    }

    public boolean need(boolean[][][] canBeFilled, char digit) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (canBeFilled[digit-'1'][i][j]) {
                    return true;
                }
            }
        }

        return false;
    }
}
