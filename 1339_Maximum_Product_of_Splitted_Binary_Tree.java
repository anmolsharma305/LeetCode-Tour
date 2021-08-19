/*
@Author: Anmol Kumar Sharma
Problem: Maximum Product of Splitted Binary Tree
Problem Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/615/week-3-august-15th-august-21st/3903/
Reference Link: https://www.youtube.com/watch?v=EVr0x96Wbec
*/

class Solution {
    private long totalSum = 0;       //It will store the total sum of the given tree
    private long maxProduct = 0;     //Maximum Product
    
    public void totalTreeSum(TreeNode root) {
        //calculating total sum of tree
        
        if(root == null) return;
        
        totalTreeSum(root.left);
        totalTreeSum(root.right);
        
        totalSum += (long)root.val;
    }
    public long calculateSubtreeSum(TreeNode root) {
        if(root == null) return 0;
        
        long l = calculateSubtreeSum(root.left);
        long r = calculateSubtreeSum(root.right);
        
        long subtreeSum = l + r + root.val;
        
        maxProduct = Math.max(maxProduct, (totalSum - subtreeSum) * subtreeSum);
        return subtreeSum;
    }
    public int maxProduct(TreeNode root) {
        //traversing in post-order
        totalTreeSum(root);
        
        //calculating sum of each subTree
        calculateSubtreeSum(root);
        
        return (int) (maxProduct % ((int)Math.pow(10, 9) + 7));
        
    }
}
