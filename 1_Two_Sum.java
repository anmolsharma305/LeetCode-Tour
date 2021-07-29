/*
@Author: Anmol Kumar Sharma

Problem: Two Sum
Problem Link: https://leetcode.com/problems/two-sum/

Time Complexity: O(N)
Space Complexity: O(N)
*/

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] result = new int[2];
        
        HashMap <Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < n; i++) {
            if(map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
            }
            map.put(nums[i] , i);
        }
        return result;
    }
}
