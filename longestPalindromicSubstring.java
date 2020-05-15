/**
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
*/

class Solution {
    int[][] isPal;
    public String longestPalindrome(String s) {
        isPal = new int[s.length()][s.length()];
        if (s.length() <= 1) return s;
        int longest[] = new int[s.length()];
        for (int i=0; i<s.length()-1; i++) {
            for (int j=s.length()-1; j>=i; j--) {
                if (isPalindrome(s, i, j)) {
                    longest[i] = j-i;
                    break;
                }
            }
        }
        int maxLength = -1;
        int maxLengthIndex = -1;
        for (int i=0; i<longest.length; i++) {
            if (longest[i] > maxLength) {
                maxLength = longest[i];
                maxLengthIndex = i;
            }
        }
        return s.substring(maxLengthIndex, maxLengthIndex+maxLength+1);
    }
    
    private boolean isPalindrome(String s, int i, int j) {
        if (isPal[i][j] != 0) return isPal[i][j] == 1;
        return checkPalindrome(s, i, j);
    }
        
    private boolean checkPalindrome(String s, int i, int j) {
        if (j-i <= 0)
            return true;
        else if (s.charAt(i) == s.charAt(j)) {
            isPal[i][j] = checkPalindrome(s, i+1, j-1) ? 1 : -1;
            return isPal[i][j] == 1;
        }
        else return false;
    }
}