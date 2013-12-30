/**
 * Problem:
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 *
 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
 *
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 *   A solution set is:
 *   (-1,  0, 0, 1)
 *   (-2, -1, 1, 2)
 *   (-2,  0, 0, 2)
 */

/**
 * Aglorithm 1:
 * Use the algorithm similar as 3Sum.
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();
        ArrayList<Integer> quadruplet;
        
        if (num.length < 4) {
            return result;
        }
        
        Arrays.sort(num);
        
        for (int i = 0; i < num.length - 3; i++) {
            // remove duplicate a
            if (i > 0 && num[i] == num[i-1]) {
                continue;
            }
            
            for (int j = i + 1; j < num.length - 2; j++) {
                // remove duplicate b
                if (j > i + 1 && num[j] == num[j-1]) {
                    continue;
                }
                
                int indexStart = j + 1;
                int indexEnd = num.length - 1;
                while (indexStart < indexEnd) {
                    int sum = num[i] + num[j] + num[indexStart] + num[indexEnd];

                    if (sum > target) {
                        indexEnd--;
                    } else if (sum < target) {
                        indexStart++;
                    } else {
                        quadruplet = new ArrayList<Integer> ();
                        quadruplet.add(num[i]);
                        quadruplet.add(num[j]);
                        quadruplet.add(num[indexStart]);
                        quadruplet.add(num[indexEnd]);
                        result.add(quadruplet);
                        
                        // remove duplicate c d
                        do {
                            indexStart++;
                        } while (indexStart < indexEnd && num[indexStart] == num[indexStart-1]);
                        do {
                            indexEnd--;
                        } while (indexStart < indexEnd && num[indexEnd] == num[indexEnd+1]);
                        
                    }
                }
            }
        }
        
        return result;
    }
}
