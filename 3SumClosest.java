/**
 * Problem:
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 *
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */

/**
 * Aglorithm 1:
 * Use the algorithm similar as 3Sum.
 */
public class Solution {
    public int threeSumClosest(int[] num, int target) {
        int result = 0;
        if (num.length < 3) {
            return result;
        }
        // initialize result 
        result = num[0] + num[1] + num[2];
        // sort the number array
        Arrays.sort(num);
        
        for (int i = 0; i < num.length-2; i++) {
            if (i > 0 && num[i] == num[i-1]) {
                continue;
            }
            
            int indexStart = i + 1;
            int indexEnd = num.length - 1;
            
            while (indexStart < indexEnd) {
                int sum = num[i] + num[indexStart] + num[indexEnd]; 
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
                
                if (sum < target) {
                    indexStart++;
                } else if (sum > target) {
                    indexEnd--;
                } else if (sum == target) {
                    return result;
                }
            }
        }
        
        return result;
    }
}
