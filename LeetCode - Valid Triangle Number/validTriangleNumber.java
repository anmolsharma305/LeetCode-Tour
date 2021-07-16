/*
@Author: Anmol Kumar Sharma
Problem: Valid Triangle Number

PROBLEM STATEMENT:

Given an integer array nums, return the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.

EXAMPLE 1:
Input: nums = [2,2,3,4]
Output: 3

Explanation:
Valid combinations are: 
2,3,4 (using the first 2)
2,3,4 (using the second 2)
2,2,3

EXAMPLE 2:
Input: nums = [4,2,3,4]
Output: 4
 

CONSTRAINTS:

1. 1 <= nums.length <= 1000
2. 0 <= nums[i] <= 1000
*/

/*
Approach: Three Pointer Approach
Time Complexity: O(N^2)
Space Complexity: O(1)
*/

class Solution {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        
        if(nums == null || n < 3) return 0;
        
               
        //Sorting the array
        Arrays.sort(nums);
        
        //Now applying three pointer approach
        int count = 0;
        int left;
        int right;
        
        for(int i = n-1; i >= 2; i--){
            left = 0;
            right = i - 1;
            
            while(left < right){
                if(nums[left] + nums[right] > nums[i]){
                    count += right - left;
                    right--;
                }
                
                else left++;
            }
            
        }
        return count;
    }
}
