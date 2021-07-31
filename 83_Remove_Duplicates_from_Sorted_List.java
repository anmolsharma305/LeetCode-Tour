/*
@Author: Anmol Kumar Sharma

Problem: Remove Duplicates from Sorted List
Problem Link: https://leetcode.com/problems/remove-duplicates-from-sorted-list/

Time Complexity: O(N)
Space Complexity: O(N)
*/

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        Set<Integer> set = new HashSet();
        
        ListNode current = head;
        ListNode previous = null;
        
        while(current != null) {
            if(set.contains(current.val)){
                previous.next = current.next;
            } else {
                set.add(current.val);
                previous = current;
            }
            current = current.next;
        }
        return head;
    }
}
