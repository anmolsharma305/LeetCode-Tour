/*
@Author: Anmol Kumar Sharma

Problem:Rotate List
Problem Link: https://leetcode.com/problems/rotate-list/

Approach Used: Two Pointer
Time Complexity:O(N)
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
    public static int size(ListNode head) {
        int count = 0;
        
        ListNode current = head;
        while(current != null){
            count++;
            current = current.next;
        }
        return count;
    }
    public ListNode rotateRight(ListNode head, int k) {
        int size = size(head);
        
        if(size < 2) return head;
        
        k %= size;
        
        //using two pointer and moving one pointer k position ahead
        //move first pointer k position ahead
        ListNode first = head;
        for(int i = 1; i <= k && first != null; i++){
            first = first.next;
        }
        
        //now start the second pointer from head
        //when first pointer to end the second will be at the position from where we have to rotate
        ListNode second = head;
        while(first.next != null){
            second = second.next;
            first = first.next;
        }
        
        //some pointer operations
        first.next = head;
        head = second.next;
        second.next = null;
        
        return head;
    }
}
