/**
 * Problem:
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 */

/**
 * Aglorithm 1:
 * Find the first target, then find the last target.
 */
public class Solution {
    public int[] searchRange(int[] A, int target) {
    int start = 0;
    int end = A.length - 1;
    int mid;
    int first = -1;
    int last = -1;
    
    while (start <= end) {
        mid = start + (end - start)/2;
        if (target < A[mid]) {
            end = mid -1;
        } else if (target > A[mid]) {
            start = mid + 1;
        } else {
            if (mid == start) {
                first = mid;
                break;
            } else if (target > A[mid-1]) {
                first = mid;
                break;
            } else {
                end = mid - 1;
            }
        }
    }
    
    start = 0;
    end = A.length - 1;
    while (start <= end) {
        mid = start + (end - start)/2;
        if (target < A[mid]) {
            end = mid -1;
        } else if (target > A[mid]) {
            start = mid + 1;
        } else {
            if (mid == end) {
                last = mid;
                break;
            } else if (target < A[mid+1]) {
                last = mid;
                break;
            } else {
                start = mid + 1;
            }
        }
    }
    
    return new int[]{first, last};
    }
}
