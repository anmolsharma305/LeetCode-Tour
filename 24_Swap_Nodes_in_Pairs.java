/*
@Author: Anmol Kumar Sharma

Problem: Swap Nodes in Pairs
Problem Link: https://leetcode.com/problems/swap-nodes-in-pairs/

Time Complexity: O(N)
Reference: https://java2blog.com/java-program-to-reverse-linked-list-in/
*/

//Approach 1: 
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

//Aproach 2: 

class Solution {    
    public ListNode swapPairs(ListNode head) {
        
        ListNode dummy = new ListNode(-1);  //creating dummy node;
        ListNode prev = dummy;
        ListNode current = head;
        dummy.next = head;
        
        
        while(current != null && current.next != null){
            prev.next = current.next;
            current.next = current.next.next;
            prev.next.next = current;
            
            current = current.next;
            prev = prev.next.next;
        }
        
        return dummy.next;
        
    }
}
