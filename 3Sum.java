/**
 * Problem:
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 *    For example, given array S = {-1 0 1 2 -1 -4},
 *
 *    A solution set is:
 *    (-1, 0, 1)
 *    (-1, -1, 2)
 */

/**
 * Aglorithm 1:
 * 
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        int indexStart = 0;
        int indexEnd = num.length - 1;
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> triplet;

        while (indexStart < indexEnd-1) {
            for (int i = indexStart + 1; i < indexEnd; i++) {
                if (num[indexStart] + num[indexEnd] + num[i] == 0) {
                    triplet = new ArrayList<Integer>();
                    triplet.add(num[indexStart]);
                    triplet.add(num[i]);
                    triplet.add(num[indexEnd]);
                    result.add(triplet);
                    break;
                }
            }

            if (num[indexStart] + num[indexEnd] >= 0) {
                indexEnd--;
                while (indexStart < indexEnd-1 && num[indexEnd] == num[indexEnd + 1]) {
                    indexEnd--;
                }
            } else {
                indexStart++;
                while (indexStart < indexEnd-1 && num[indexStart] == num[indexStart - 1]) {
                    indexStart++;
                }
            }
        }

        return result;
    }
}
