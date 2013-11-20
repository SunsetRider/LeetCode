/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */

/**
 * Algorithm 1:
 * Treat the string as three parts: first row, last row and the other rows.
 */

public class Solution {
    public String convert(String s, int nRows) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (s.length() == 0 || nRows == 1)
            return s;
            
        int subLength = nRows*2-2;
        int subNum = s.length()%subLength == 0 ? s.length()/subLength : s.length()/subLength+1;
        
        String cnvtString = new String();
        
        for (int i = 0; i < subNum; i++)
            if (subLength*i < s.length())
                cnvtString += s.charAt(subLength*i);
        
        for (int row = 1; row < nRows-1; row++)    
            for (int i = 0; i < subNum; i++) {
                if (subLength*i + row < s.length())
                    cnvtString += s.charAt(subLength*i + row);
                if (subLength*i + subLength - row < s.length())
                    cnvtString += s.charAt(subLength*i + subLength - row);
            }
            
        for (int i = 0; i < subNum; i++)
            if (subLength*i + nRows - 1 < s.length())
                cnvtString += s.charAt(subLength*i + nRows - 1);
            
        return cnvtString;
    }
}