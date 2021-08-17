/*
@Author: Anmol Kumar Sharma
Problem: Count Good Nodes in Binary Tree
Problem Link:https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/615/week-3-august-15th-august-21st/3899/
Time Complexity: O(N), where N is the number of nodes in the Binary Tree
*/
class Solution {
    static int rec(TreeNode root, int max)
    {
        if(root == null) return 0;
        
        int cur = 0;
        if(max <= root.val) cur++;
        
        max = Math.max(max, root.val);
        return rec(root.left, max) + rec(root.right, max) + cur;
    }
    
    public int goodNodes(TreeNode root) {
        int max = Integer.MIN_VALUE;
        return rec(root,max);  
    }
}
