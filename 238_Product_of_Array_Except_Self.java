/*
@Author: Anmol Kumar Sharma

Problem: Product of Array Except Array
Problem Link: https://leetcode.com/problems/product-of-array-except-self/

Time Complexity: O(N)
*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] leftProduct = new int[n];
        int[] rightProduct = new int[n];
        int[] result = new int[n];
        int preProduct = 1;
        leftProduct[0] = 1;
        
        //calculating leftProduct for each element
        for(int i = 1; i < n; i++){
            preProduct *= nums[i-1];
            leftProduct[i] = preProduct;
        }
        
        //calculating rightProduct for each element
        int postProduct = 1;
        rightProduct[n-1] = 1;
        for(int i = n-2; i >= 0; i--){
            postProduct *= nums[i+1];
            rightProduct[i] = postProduct;
        }
        
        //calculation the product of arrat expect ith element
        for(int i = 0; i < n; i++){
            result[i] = leftProduct[i] * rightProduct[i];
        }
        return result;
    }
}
