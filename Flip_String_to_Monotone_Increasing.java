/*
@Author: Anmol Kumar Sharma

Problem: Flip String to Monotone Increasing
Problem Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/614/week-2-august-8th-august-14th/3876/
Reference Link: https://www.youtube.com/watch?v=XEFEbvKUE_Y

Time Complexity: O(N)
Space Complexity: O(1)
*/

class Solution {
    public int minFlipsMonoIncr(String s) {
        int oneCount = 0;
        int zeroCount = 0;
        int i = 0;
        
        while(i < s.length() && s.charAt(i) == '0') {
            i++;
        }
        for(; i < s.length(); i++){
            char c = s.charAt(i);
            if(c =='0') zeroCount++;
            else oneCount++;
            
            zeroCount = (zeroCount > oneCount) ? oneCount : zeroCount;
        }
        return zeroCount;
    }
}
