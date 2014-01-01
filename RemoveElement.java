/**
 * Problem:
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * 
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */

/**
 * Aglorithm 1:
 * Straightforward.
 */
public class Solution {
    public int removeElement(int[] A, int elem) {
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == elem) {
                continue;
            }
            
            A[result++] = A[i];
        }
        
        return result;
    }
}
