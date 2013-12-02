/**
 * Problem:
 * Given n non-negative integers a1, a2, ..., an, 
 * where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container,
 * such that the container contains the most water.
 *
 * Note: You may not slant the container.
 */

/**
 * Algorithm 1:
 * Straightforward algorithm;
 * Still need to reduce the running time. 
 */
public class Solution {
    public int maxArea(int[] height) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        int maxArea = 0;
        int maxHeight = 0;
        int maxLength = 0;
        int tempArea;
        int tempHeight;
        int tempLength;
        
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++){
                tempHeight = height[i] < height[j] ? height[i] : height[j];
                tempLength = j - i;
                if (tempHeight > maxHeight || tempLength > maxLength) {
                    tempArea = tempHeight * tempLength;
                    if (tempArea > maxArea) {
                        maxArea = tempArea;
                        maxHeight = tempHeight;
                        maxLength = tempLength;
                    }
                }
            }
        }
        
        return maxArea;
    }
}

/**
 * Algorithm 2:
 * 1.Use the first height as left boundary and the last height as right boudary;
 * 2.Move the shorter boudary to middle to the larger height;
 * 3.Calculate the new area and update the max area.
 */
public class Solution {
    public int maxArea(int[] height) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.

        if (height.length == 0) {
            return 0;
        }

        int leftIndex = 0;
        int rightIndex = height.length-1;

        int lowerHeight = 0;
        int maxArea = 0;

        while (leftIndex != rightIndex) {
            if (Math.min(height[leftIndex], height[rightIndex]) > lowerHeight) {
                lowerHeight = Math.min(height[leftIndex], height[rightIndex]);
                maxArea = Math.max((rightIndex - leftIndex)*(lowerHeight), maxArea);
            }

            if (height[leftIndex] < height[rightIndex]) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }

        return maxArea;
    }
}


