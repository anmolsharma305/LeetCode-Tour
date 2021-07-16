/*
@ Author: Anmol Kumar Sharma

PROBLEM STATEMENT: 

Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

1. 0 <= a, b, c, d < n
2. a, b, c, and d are distinct.
3. nums[a] + nums[b] + nums[c] + nums[d] == target

You may return the answer in any order.

EXAMPLE 1: 

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

EXAMPLE 2:

Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]

CONSTRAINTS:

1. 1 <= nums.length <= 200
2. -109 <= nums[i] <= 109
3. -109 <= target <= 109
*/

/*
Problem: 4 Sum
Approach: Two Pointer Appraoch
Time Complexity: O(N^3 log N) 
*/

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        HashSet<List<Integer>> s = new HashSet();
        int n =  nums.length;
        int sum;
        
        Arrays.sort(nums);
        
        for(int i = 0; i < n-3; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;     //for duplicate value just skip them
            for(int j = i+1; j < n-2; j++){
                if(j > i+1 && nums[j] == nums[j-1]) continue;   //for duplicate value just skip them
                
                int low = j+1;
                int high = n-1;
                
                //apply two pointer
                while(low < high) {
                    sum = nums[i] + nums[j] + nums[low] + nums[high];
                    
                    if(sum > target)
                        high--;
                    
                    else if (sum ==  target) {
                        List<Integer> l = new ArrayList();
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[low]);
                        l.add(nums[high]);
                        
                        s.add(l);
                        low++;
                    }
                    
                    else low++;
                }
            }
        }
        
        List<List<Integer>> result = new ArrayList();
        for(List i: s){
            result.add(i);
        }
        
               
        return result;
    }
}



