/*
@Author: Anmol Kumar Sharma

Problem: Path Sum II
Problem Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/613/week-1-august-1st-august-7th/3838/
*/

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(res, path, root, sum);
        return res;
    }
    private void dfs(List<List<Integer>> res, List<Integer>path, TreeNode root, int sum){
        if(root == null) return;
            path.add(root.val);
        
        if(root.left == null && root.right == null) {
            if(sum == root.val) res.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
            
            return;
        }
        dfs(res, path, root.left, sum - root.val);
        dfs(res, path, root.right, sum - root.val);
        path.remove(path.size() - 1);
    }
}
