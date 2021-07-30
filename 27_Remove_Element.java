/*
@Author: Anmol Kumar Sharma

Problem: Remove Element
Problem: https://leetcode.com/problems/remove-element/

Time Complexity: O(N)
Space Complexity: O(1)

Approach used: Move all Zeroes to the end of the array
Link: https://www.geeksforgeeks.org/move-zeroes-end-array/
*/

class Solution {
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        
        int count = 0;
        
        for(int i = 0; i < n; i++){
            if(val != nums[i]){
                swap(nums, count, i);
                count++;
            }
        }
        return count;
    }
}
