/*
@Author: Anmol Kumar Sharma

Problem: Swap Nodes in Pairs
Problem Link: https://leetcode.com/problems/swap-nodes-in-pairs/

Time Complexity: O(N)
Reference: https://java2blog.com/java-program-to-reverse-linked-list-in/
*/

class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode current = head;
        ListNode temp = null;
        ListNode newHead = null;
        
        
        while(current != null && current.next != null){
            if(temp != null){
                temp.next.next = current.next;
            }
            
            temp = current.next;
            current.next = temp.next;
            temp.next = current;
            
            if(newHead == null){
                newHead = temp;
            }
            current = current.next;
        }
        return newHead;
    }
}
