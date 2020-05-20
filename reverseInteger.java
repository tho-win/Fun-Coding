/**
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
*/

class Solution {
    public int reverse(int x) {
        /* solution 1, takes up too much time
        boolean isNeg = x < 0 ? true : false;
        x = isNeg ? -x : x;
        Queue<Integer> nums = new LinkedList<>();
        while (true) {
            if (x <= 0) break;
            int mod = x % 10;
            x = x / 10;
            nums.add(mod);
        }
        int ret = 0;
        while (nums.size() > 0) {
            int n = nums.poll();
            int tempRet= (int)(n * Math.pow(10, nums.size()));
            if (tempRet / Math.pow(10, nums.size()) != n) return 0;
            ret += tempRet;
            if (ret < 0) return 0;
        }
        return isNeg ? -1 * ret : ret;
        */
        
        //Solution 2
        int rev = 0;
        while (x != 0) {
            int pop = x % 10; 
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE/10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE/10 && pop < -8)) return 0;
            rev = rev*10 + pop;
        }
        return rev;
    }
}