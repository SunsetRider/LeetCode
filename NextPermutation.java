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

/**
 * Aglorithm 2:
 * 1.Find the longest descending tail of the array and reverse them into ascending order.
 * 2.Replace the number aheand of the tail with the first number which is larger in the tail.
 */
public class Solution {
    public void nextPermutation(int[] num) {
        if (num.length < 2) {
            return;
        }

        // find the longest descending tail
        int index = -1;
        for (int i = num.length-2; i >= 0; i--) {
            if (num[i] < num[i+1]) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            for (int i = 0; i < num.length/2; i++) {
                swap(num, i, num.length-1-i);
            }
            return;
        }

        // reverse the descending tail
        for (int i = 0; i < (num.length-index)/2; i++) {
            swap(num, index+1+i, num.length-1-i);
        }

        // replace num[index] with the first number which is larger in the tail
        for (int i = index+1; i < num.length; i++) {
            if (num[i] > num[index]) {
                swap(num, i, index);
                return;
            }
        }
    }

    public void swap (int[] num, int a, int b) {
        int temp = num[a];
        num[a] = num[b];
        num[b] = temp;
    }
}
