/*
@Author: Anmol Kumar Sharma

Problem: Find Pivot Index
Problem Link: https://leetcode.com/problems/find-pivot-index/
*/

/*
My Approach:

Idea is to use the fact i.e : left_sum + pivot = pivot + right_sum
So, we need to find the running sum of array from left to right and store in an array i.e, leftSum[]
and running sum from right to left in an array i.e, rightSum[]

and if pivot exist then it will be at the same index in both the array.
so to find pivot simply traver both array simantenously and find pivot otherwise return -1.

Example: 
arr[] = [1, 7, 3, 6, 5, 6]

leftSum[] = [1, 8, 11, 17, 22, 28]

rightSum[] = [28, 27, 20, 17, 11, 6]

now traversing the array we will get 3rd index as a pivot index
So, output is 3

*/
class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        
        if(n == 0) return -1;
        
        int[] lSum = new int[n];
        int[] rSum = new int[n];
        lSum[0] = nums[0];
        rSum[n-1] = nums[n-1];
        
        for(int i = 1; i < n; i++) {
            lSum[i] = nums[i] + lSum[i-1];
            rSum[n-i-1] = nums[n-i-1] + rSum[n-i];
        } 
        
        for(int i = 0 ; i < n; i++){
            if(lSum[i] == rSum[i])
                return i;
        }
        
        return -1;
    }
}
