/**
 * Problem: 
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * click to show spoilers.
 * 
 * Some hints:
 * Could negative integers be palindromes? (ie, -1)
 * 
 * If you are thinking of converting the integer to string, note the restriction of using extra space.
 * 
 * You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?
 * 
 * There is a more generic way of solving this problem.
 */

/**
 * Algorithm 1:
 * 1.Reverse the integer;
 * 2.Compare the reversed integer with the original.
 */
public class Solution {
    public boolean isPalindrome(int x) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        if (x < 0)
            return false;
            
        int rev = 0;
        int num = x;
        while (num != 0) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        
        return rev == x;
    }
}

/**
 * Algorithm 2:
 * Compare the digits from the ends to middle.
 */
public class Solution {
    public boolean isPalindrome(int x) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.

        if (x < 0)
            return false;
        else if (x >= 0 && x <= 9) {
            return true;
        }

        int length = 0;

        for (int n = x; n != 0; n /= 10) {
            length++;
        }

        int num = x;
        for (int i = 0; i < length/2; i++, num /= 10) {
            if (x/(int)Math.pow(10, length-1-i)%10 != num%10) {
                return false;
            }
        }

        return true;
    }
}

