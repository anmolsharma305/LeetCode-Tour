/*
@Author: Anmol Kumar Sharma
Problem: Verify Preorder Serialization of a Binary tree
Problem Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/616/week-4-august-22nd-august-28th/3920/
Refernce Link: https://www.youtube.com/watch?v=RzNYwhSQjHQ

Time Complexity: O(N), where N is the length of given preorder string
*/

class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        
        int nullCount = 1;
        
        for(String node: nodes) {
            // visiting a node 
            nullCount--;
            
            if(nullCount < 0) return false;
            
            if(!node.equals("#")) {
                nullCount += 2;
            }
        }
        return (nullCount == 0);
    }
}
