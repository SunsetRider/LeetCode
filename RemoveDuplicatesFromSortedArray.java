/**
 * Problem:
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * 
 * For example,
 * Given input array A = [1,1,2],
 * 
 * Your function should return length = 2, and A is now [1,2].
 */

/**
 * Aglorithm 1:
 * Compare the current number with the number before it.
 */
public class Solution {
    public int removeDuplicates(int[] A) {
        if (A.length < 2) {
            return A.length;
        }

        int result = 1;
        int lastNum = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] == lastNum) {
                continue;
            }

            lastNum = A[i];
            A[result] = A[i];
            result++;
        }

        return result;
    }
}
