/**
 * Problem:
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 *
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * 
 * The replacement must be in-place, do not allocate extra memory.
 * 
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */

/**
 * Aglorithm 1:
 * Traverse from the number next to the end to the start, find out the smallest number 
 * which is larger than the current number in the area between current position and the end of the array.
 */
public class Solution {
    public void nextPermutation(int[] num) {
        if (num.length < 2) {
            return;
        }
        
        for (int i = num.length-2; i >= 0; i--) {
            int sl = Integer.MAX_VALUE; // the samllest number larger than num[i]
            int index = -1; // the index of the number need to be swapped
            for (int j = i+1; j < num.length; j++) {
                if (num[j] > num[i] && num[j] < sl) {
                    sl = num[j];
                    index = j;
                }
            }
            
            if (index != -1) {
                int temp = num[index];
                num[index] = num [i];
                num[i] = temp;
            
                Arrays.sort(num, i+1, num.length);
                return;
            }
        }
        // if the array is in descending order
        Arrays.sort(num);
        return;
    }
}
