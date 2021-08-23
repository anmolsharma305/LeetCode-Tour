/*
@Author: Anmol Kumar Sharma
Problem: Two Sum IV - Input is a BST
Problem Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/616/week-4-august-22nd-august-28th/3908/
*/

/*
Approach-1: 
* Traverse the BST in Inorder[Left - Root - Right] manner and store each element in the Array.
* After this we will get a sorted arrat, then apply Two Pointer Approach to find element whose sum is k.

Note: This approach requires two traversal:
      1 - for BST
      2 - two pointer on array

Time Complexity: O(N)
Space Complexity: O(N)
*/

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);
        int left = 0;
        int right = nums.size() - 1;
        
        while(left < right) {
            if(nums.get(left) + nums.get(right) == k) return true;
            if(nums.get(left) + nums.get(right) < k) left++;
            else { right--; }
        }
        return false;
    }
    
    public void inorder(TreeNode root, List<Integer> nums) {
        if(root == null) return;
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }
}

/*
Approach - 2: (Using HashSet)
* Traverse the BST in Preorder and for each root:
    * check if (k - root.val) exist in HashSet if yes then return true else add the add root.val into the HashSet.
    * After after traversing whole BST and and no element is found then return false.
* This Approach works in one traversal only.

Time Complexity: O(N)
Space Complexity: O(N)
*/

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();        
        return preOrder(root, k, set);
    }
    
    public boolean preOrder(TreeNode root, int k, HashSet<Integer> set) {
        if(root == null)  return false;
        
        int element = k - root.val;
        
        if(set.contains(element)) return true;
        
        set.add(root.val);
        return preOrder(root.left, k, set) || preOrder(root.right, k, set);
        
    }
}
