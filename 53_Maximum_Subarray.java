/*
@Author: Anmol Kumar Sharma

Problem: Maximum Subarray Sum
Problem Link: https://leetcode.com/problems/maximum-subarray/

Approach used: Kadane's Algorithm
Time complexity: O(N)
*/

class Solution {
    public int maxSubArray(int[] nums) {
        int csum = nums[0];     //store current sum
        int osum = nums[0];     //store overall sum
        
        for(int i = 1; i < nums.length; i++){
            if(csum >= 0){
                csum += nums[i];    //if csum is +ve then appen is element to the subarray
            }
            else{
                csum = nums[i];     // else start new subarray
            }
            
            if(csum > osum){
                osum = csum;
            }
        }
        return osum;
    }
}
