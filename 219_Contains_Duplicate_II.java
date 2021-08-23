/*
@Author: Anmol Kumar Sharma
Problem: Contains Duplicate II
Problem Link: https://leetcode.com/problems/contains-duplicate-ii/ 

Time Complexity: O(N)
Space Complexity: O(N)
*/

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length == 1) return false;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i]) && (Math.abs(map.get(nums[i]) - i) <= k)) {
                return true;
            }
            else{
                map.put(nums[i], i);
            }
        }
        return false;
    }
}
