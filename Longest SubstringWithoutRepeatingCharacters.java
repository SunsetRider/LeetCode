/* 
*  Problem:
*  Given a string, find the length of the longest substring without repeating characters.
*  For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
*  For "bbbbb" the longest substring is "b", with the length of 1.
*/

/*
*  Algorithm 1:
*  1.Find all the substrings without repeating characters.
*  2.Find the max length of the substrings. 
*  Time Complexity:
*  O(n)
*/
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        if(s == null || s.length() == 0)
            return 0;
        
        int max;
        List<Integer> lengths = new ArrayList<Integer>();
        StringBuilder subString = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
                                       // return the String representation of c
            int index = subString.indexOf(String.valueOf(c));
            
            if (index != -1){ 
                lengths.add(subString.length());
                // delete c and the charactors before c in the subString
                if(index+1 == subString.length())
                    subString = new StringBuilder();
                else
                    subString = subString.delete(0, index+1);
            } 
            
            subString = subString.append(c);
        }
        // add the last subString's length
        lengths.add(subString.length());

        max = Collections.max(lengths);
        
        return max;
    }
}

