/*
@Author: Anmol Kumar Sharma

Problem: Search Insert Position
Problem Link: https://leetcode.com/problems/search-insert-position/

Approach used: Binary Search
Time Complexity: O(log(N))
*/

class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        
        int low = 0;
        int high =  n-1;
        
        // if element is present in the array
        //apply binary search
        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            if(nums[mid] == target) return mid;
            
            else if(nums[mid] < target) low = mid + 1;
            
            else high = mid - 1;
        }
        
        // if element is not present in the array
        return low;
    }
}
