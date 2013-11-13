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

/*
*  Algorithm 2:
*  1.Track the length of substring without repeating characters while travesing the string;
*  2.Compare the current length with max length, if it's larger than max, set it to max.
*  Time Complexity:
*  O(n)
*/

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
    
        if (s == null || s.length() == 0)
            return 0;

        List<Character> subString = new ArrayList<Character>();
        int maxLength = 1;
        int curentLength = 0;

        for (int index = 0; index < s.length(); index++) {
            char c = s.charAt(index);
            if (subString.contains(c)) {
                if (curentLength > maxLength)
                    maxLength = curentLength;

                int indexOfc = subString.indexOf(c);
                subString = subString.subList(indexOfc + 1, subString.size());
                curentLength -= indexOfc + 1;
            }

            subString.add(c);
            curentLength++;
        }
        // compare the last substring's length with the max length
        if (curentLength > maxLength)
                maxLength = curentLength;

        return maxLength;
        }
}