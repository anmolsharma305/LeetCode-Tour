/*
@Author: Anmol Kumar Sharma

Problem:Rotate List
Problem Link: https://leetcode.com/problems/rotate-list/

*/

/*
Approach-1: Two Pointer
Time Complexity:O(N)
Space Complexity: O(1)
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

/*
Approach-2: Simple and Easy

Time Complexity: O(N)
Space Complexity: O(1)
Reference: https://www.youtube.com/watch?v=9VPm6nEbVPA&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=39
*/
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        //Edge cases 
        if(head == null || head.next == null || k == 0) return head;
        
        //finding length of the list
        ListNode current = head;
        int len = 1;
        while(current.next != null){
            len++;
            current = current.next;
        }
        
        //making it as circular list 
        current.next = head;
        
        //if k is greater or equals to length
        k = len - k % len;
        
        
        while(k-- > 0) current = current.next;
        
        head = current.next;
        current.next = null;
        
        return head;
        
    }
}
