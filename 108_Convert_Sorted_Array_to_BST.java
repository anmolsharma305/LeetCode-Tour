/*
@Author: Anmol Kumar Sharma

Problem: Convert Sorted Array to Binary Search Tree
Problem Link: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

Time Complexity: O(log(N))
Space Complexity: O(N), for function call stack
*/

class Solution {
    
    private TreeNode helper(int[] nums, int low, int high) {
        if(low > high) return null;
        
        int mid = low + (high - low) / 2;
        
        // mid element will be our root node;
        TreeNode head = new TreeNode(nums[mid]);
        
        // left half before mid will be our left sub tree
        head.left = helper(nums, low, mid-1);
        
        //right half after mid will be our right sub tree
        head.right = helper(nums, mid+1, high);
        
        return head;
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }
}
