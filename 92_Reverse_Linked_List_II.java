/*
@Author: Anmol Kumar Sharma

Problem: Reverse Linked List II
Problem Link: https://leetcode.com/problems/reverse-linked-list-ii/

Reference Link: https://leetcode.com/problems/reverse-linked-list-ii/discuss/1385772/Java-O(1)-space-One-time-pass-Faster-than-100
*/

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode firstListTail = dummy;
        
        int i = 0;
        while(i++ < left - 1) {
            firstListTail = firstListTail.next;
        }
        
        int rmoves = right - left + 1;
        ListNode revListTail = firstListTail.next;
        ListNode current = firstListTail.next;
        ListNode prev = null;
        ListNode currentNextNode = null;
        
        while(rmoves > 0) {
            currentNextNode = current.next;
            current.next = prev;
            prev = current;
            current = currentNextNode;
            
            rmoves--;            
        }
        
        revListTail.next = current;
        firstListTail.next = prev;
        
        return dummy.next;
        
    }
}
