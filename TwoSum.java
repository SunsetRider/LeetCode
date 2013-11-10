public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        int[] index = new int[2];
        
        for (int i = 0; i < numbers.length; i++)
            for(int j = i+1; j < numbers.length; j++)
                if(numbers[i] + numbers[j] == target){
                    index[0] = i + 1;
                    index[1] = j + 1;
                    
                    break;
                }
                
        return index;
                    
    }
}
