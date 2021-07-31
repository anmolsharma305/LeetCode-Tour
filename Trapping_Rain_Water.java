/*
@Author: Anmol Kumar Sharma

Problem: Trapping rain Water
Problem Link: https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/612/week-5-july-29th-july-31st/3833/
*/

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int result = 0;
 
        if(height == null || n <= 2)
            return result;

        int left[] = new int[n];
        int right[] = new int[n];

        //scan from left to right
        int max = height[0];
        left[0] = height[0];
        for(int i = 1; i < n; i++){
            if(height[i] < max){
                left[i] = max;
            }else {
                left[i] = height[i];
                max = height[i];
            }
        }

        //scan from right to left
        max = height[n - 1];
        right[n - 1] = height[n - 1];
        for(int i = n - 2; i >= 0; i--){
            if(height[i] < max){
                right[i] = max;
            }else {
                right[i] = height[i];
                max = height[i];
            }
        }

        //calculate total
        for(int i = 0; i < n; i++){
            result += Math.min(left[i], right[i]) - height[i];
        }

        return result;
    }
}
