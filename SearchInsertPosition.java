/**
 * Problem:
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 *
 * Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 */

/**
 * Aglorithm 1:
 * Straightforward.
 */
public class Solution {
    public int searchInsert(int[] A, int target) {
    int index = -1;
    int start = 0;
    int end = A.length - 1;
    int mid;
    
    while (start <= end) {
        mid = start + (end-start)/2;
        if (target > A[mid]) {
            index = mid + 1;
            start = mid + 1;
        } else if (target < A[mid]) {
            end = mid - 1;
        } else {
            index = mid;
            break;
        }
    }
    
    if (index == -1) {
        return 0;
    }
    
    return index;
    }
}
