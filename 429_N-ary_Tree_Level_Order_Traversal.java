/*
@Author: Anmol Kumar Sharma

Problem: N-ary Tree Level Order Traversal
Problem Link: https://leetcode.com/problems/n-ary-tree-level-order-traversal/
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        //creating the final result that is to be returned
        List<List<Integer>> result = new ArrayList<>();
        
        //check is root is null
        if(root == null) return result;
        
        //if root is not null
        Queue<Node> q = new LinkedList<>();
        
        //add root to the queue
        q.add(root);
        
        //iterate untill queue is empty
        while(!q.isEmpty()){
            //calculate the size
            int size = q.size();
            
            List<Integer> currentLevel = new ArrayList<>();
            
            for(int i = 0; i < size; i++){
                Node element = q.poll();
                currentLevel.add(element.val);
                for(Node child: element.children){
                    q.add(child);
                }
            }
            result.add(currentLevel);
            
        }
        return result;
        
    }
}
