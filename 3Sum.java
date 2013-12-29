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
 * 1.Sort the array in ascending order;
 * 2.Traverse the number not larger than 0 as a, then find the b c in the rest of the array such that a+b+c == 0
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> triplet;

        // make sure the input array's length is not less than 3
        if (num.length < 3) {
            return result;
        }

        Arrays.sort(num);

        // for each a not larger than 0 find respective b c
        for (int i = 0; i < num.length - 2 && num[i] <= 0; i++) {
            // remove duplicate a
            if (i > 0 && num[i] == num[i-1]) {
                continue;
            }

            int indexStart = i + 1;
            int indexEnd = num.length - 1;
            while (indexStart < indexEnd) {
                int sum = num[i] + num[indexStart] + num[indexEnd];
                if (sum < 0) {
                    indexStart++;
                } else if (sum > 0) {
                    indexEnd--;
                } else {
                    triplet = new ArrayList<Integer>(3);
                    triplet.add(num[i]);
                    triplet.add(num[indexStart]);
                    triplet.add(num[indexEnd]);
                    result.add(triplet);

                    // remove duplicate b c
                    do {
                        indexStart++;
                    } while (indexStart < indexEnd && num[indexStart] == num[indexStart-1]);

                    do {
                        indexEnd--;
                    } while (indexStart < indexEnd && num[indexEnd] == num[indexEnd+1]);
                }
            }
        }

        return result;
    }
}
