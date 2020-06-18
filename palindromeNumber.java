/**
Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:

Input: 121
Output: true
Example 2:

Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 */

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x/10 == 0) return true;
        Queue<Integer> queue = new LinkedList();
        Deque<Integer> deque = new LinkedList();
        while (true) {
            int n = x%10;
            queue.add(n);
            deque.addFirst(n);
            x = x/10;
            if (x==0) break;
        }
        
        while (!queue.isEmpty() && !deque.isEmpty()) {
            if (queue.poll() != deque.pollFirst()) return false;
        }
        
        return true; 
    }
}