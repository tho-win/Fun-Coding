/**
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    ListNode zero = new ListNode(0);
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        add(l1, l2, result, 0);
        return result;
    }
    
    private void add(ListNode l1, ListNode l2, ListNode result, int overflow) {
        int sum = l1.val + l2.val + overflow;
        result.val = sum%10;
        if (l1.next == null && l2.next == null) {
            if (sum/10 == 0) return;
            else result.next = new ListNode(sum/10);
        }
        else if (l1.next == null) {
            result.next = new ListNode(0);
            add(zero, l2.next, result.next, sum/10);
        }
        else if (l2.next == null) {
            result.next = new ListNode(0);
            add(l1.next, zero, result.next, sum/10);
        }
        else {
            result.next = new ListNode(0);
            add(l1.next, l2.next, result.next, sum/10);
        }
        return;
    }
}
