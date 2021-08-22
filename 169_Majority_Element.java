/*
@Author: Anmol Kumar Sharma
Problem: Majority Element
Problem Link: https://leetcode.com/problems/majority-element/
*/

//Approach: Moore Voting Algorithm 
//Time Complexity: O(N)
//Space Complexity: O(1)

class Solution {
    public int majorityElement(int[] nums) {
        
        // find the potential candidate that can be majority element
        int value = potentialCandidate(nums);
        
        //Now, the value can be our majority element 
        //so we need to check if it frequency(value) > nms.length/2, then it will be our majority element else "No majority element will exist"
        int valueFreq = freq(nums, value);
        
        return (valueFreq > nums.length/2) ? value : -1;
    }
    
    private int potentialCandidate(int[] nums) {
        int value = nums[0];
        int count = 1;
        
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == value) {
                count++;
            } else {
                count--;
            }
            if(count == 0){
                value = nums[i];
                count = 1;
            }
        }
        return value;
    }
    
    private int freq(int[] nums, int e) {
        int count = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == e) count++;
        }
        return count;
    }
}
