/*
@Author: Anmol Kumar Sharma
Problem: 3 Sum
Problem Link: https://leetcode.com/problems/3sum/
*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        
        if(n < 3) return new ArrayList();
        
        //sorting the given Array
        Arrays.sort(nums);
        
        Set<List<Integer>> set = new HashSet();
        
        //Applying 3 pointer approach
        
        for(int i = 0; i < n-2; i++){
            int j = i + 1;
            int k = n - 1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0) {
                    set.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                }
                else if(sum > 0) k--;
                else j++;
            }
        }
        
        return new ArrayList(set);
    }
}
