/*
@Author: Anmol Kumar Sharma

Problem: Remove Nth Node From End of List
Problem Link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/

Time Complexity: O(N)
Space Complexity: O(1)
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
            ListNode first = head;
            ListNode second = head;
        
            // make second node n nodes ahead of first node;
            for (int i = 0; i < n; i++)
                second = second.next;
        
            // If second node is null, that mean n == list.size-1;
            // that means we have to remove the head of the list;
            if (second == null)
                return first.next;

            // if second node is not null, lets move both first and second nodes
            // until second.next == null;
            // remember after this, first node will n+1 nodes from the end;
            while(second.next != null) {
                first = first.next;
                second = second.next;
            }

            // we can easily skip nth node and make first.next point to n.next;
            first.next = first.next.next;

            return head;
    }
}
