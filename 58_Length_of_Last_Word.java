/*
@Author: Anmol Kumar Sharma

Problem: Length of Last Word
Problem Link: https://leetcode.com/problems/length-of-last-word/

Time complexity: O(N)
*/

class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();   // trim the leading and trailing spaces.
        int n = s.length();
        int len = 0;
        
        for(int i = n-1; i >= 0; i--) {
            if (s.charAt(i) != ' '){
                ++len;
            }
            else break;
        }
        return len;
    }
}
