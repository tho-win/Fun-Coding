/**
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 1) return 1;
        HashSet seen = new HashSet<Character>();
        int length[] = new int[s.length()] ;
        int soFar = 1;
        for (int i=0; i<s.length()-1; i++) {
            seen.add(s.charAt(i));
            for (int j=i+1; j<s.length(); j++) {
                if (!seen.add(s.charAt(j))) {
                    break;
                }
                else soFar++;
            }
            length[i] = soFar;
            soFar = 1;
            seen.clear();
        }
        int maxLength = 0;
        for (int l : length){
            if (l > maxLength) maxLength = l;
        }
        return maxLength;
    }
}
