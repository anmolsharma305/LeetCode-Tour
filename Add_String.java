/*
@Author: Anmol Kumar Sharma
 
Problem: Add String 
Problem Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/614/week-2-august-8th-august-14th/3875/
*/

class Solution {
    public String addStrings(String num1, String num2) {
        String res = "";
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        
        while(i >= 0 || j >= 0 || carry != 0) {
            int ival = i >= 0 ? num1.charAt(i) - '0' : 0;
            int jval = j >= 0 ? num2.charAt(j) - '0' : 0;
            
            i--;
            j--;
            int sum = ival + jval + carry;
            res = (sum % 10) + res;
            carry = sum /10;
        }
        return res;
    }
}
