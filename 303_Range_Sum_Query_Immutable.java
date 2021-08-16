/*
@Author: Anmol Kumar Sharma
Problem: Range Sum Query Immutable
Problem Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/615/week-3-august-15th-august-21st/3892/
Reference Link: https://www.youtube.com/watch?v=FoLSpCsQ0rA
*/
class NumArray {
    
    int leftSum[];
    public NumArray(int[] nums) {
        leftSum = new int[nums.length+1];
        
        //sum of all the element to the first element is 0 because 
        //no element is on the left of it.
        leftSum[0] = 0;
        
        //now calculate left sum of rest elements
        for(int i = 1; i <= nums.length; i++){
            leftSum[i] = leftSum[i-1] + nums[i-1];
        }
    }
    
    public int sumRange(int left, int right) {
        return leftSum[right+1] - leftSum[left];
    }
}

