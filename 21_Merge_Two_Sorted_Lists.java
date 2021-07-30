/*
@Author: Anmol Kumar Sharma

Problem: Merge Two Sorted Lists
Problem Link: https://leetcode.com/problems/merge-two-sorted-lists/
Time Complexity: O(M + N), where M is the size of first list and N is the size of second list.
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode l3;
        
        if(cur1 == null) return cur2;
        
        if(cur2 == null) return cur1;
        
        if(cur1.val < cur2.val) {
            l3 = cur1;
            l3.next = mergeTwoLists(cur1.next, cur2);
        }
        else {
            l3 = cur2;
            l3.next = mergeTwoLists(cur1, cur2.next);
        }
        return l3;
    }
}
