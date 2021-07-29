/*
@Author: Anmol Kumar Sharma
Problem: Running Sum of 1d Array
Problem Link: https://leetcode.com/problems/running-sum-of-1d-array/

Time Complexity: O(N)
Space Complexity: O(1)

*/

class Solution {
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int sum = nums[0];
        
        for(int i = 1; i < n; i++){
            sum += nums[i];
            nums[i] = sum;
        }
        
        return nums;
    }
}
