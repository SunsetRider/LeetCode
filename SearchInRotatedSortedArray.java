/**
 * Problem:
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 */

/**
 * Aglorithm 1:
 * Judge which part of the array is ascending then use binary search.
 */
public class Solution {
    public int search(int[] A, int target) {
    if (A.length == 0) {
        return -1;
    }
    
    int start = 0;
    int end = A.length-1;
    int mid;
    
    while (start <= end) {
        mid = start + (end-start)/2;
        if (A[mid] > A[start]) {
            if (target <= A[mid] && target >= A[start]) {
                return binarySearch (A, target, start, mid);
            } else {
                start = mid + 1;
            }
        } else if (A[mid] < A[start]) {
            if (target >= A[mid] && target <= A[end]) {
                return binarySearch (A, target, mid, end);
            } else {
                end = mid - 1;
            }
        } else {
            if (target == A[start]) {
                return start;
            } else if (target == A[end]) {
                return end;
            } else {
                return -1;
            }
        }
    }
    
    return -1;
    }
    
    public int binarySearch(int[] A, int target, int start, int end) {
        int mid;
        while (start <= end) {
            mid = start + (end-start)/2;
            if (target > A[mid]) {
                start = mid+1;   
            } else if (target < A[mid]) {
                end = mid-1;
            } else {
                return mid;
            }
        }
        
        return -1;
    }
}
