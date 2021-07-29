/*
@Author: Anmol Kumar Sharma

Problem: Move Zeros
Problem Link: https://leetcode.com/problems/move-zeroes/

Time Complexity: O(N)
Space Complexity: O(1)
*/

class Solution {
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        
    }
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        
        int count = 0;      //store the count of non zero values 
        
        for(int i = 0; i < n; i++){
            if(nums[i] != 0) {
                swap(nums, i, count);
                count++;
            }
        }
    }
}
