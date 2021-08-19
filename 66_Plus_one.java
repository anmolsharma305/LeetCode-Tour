  
/*
@Author: Anmol Kumar Sharma
Problem: Plus One
Problem Link: https://leetcode.com/problems/plus-one/
Time Complexity: O(N)
Space Complexity: O(N) 
*/

class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        for(int i = digits.length - 1; i >= 0; i--){
            if(digits[i] + carry == 10) {
                digits[i] = 0;
                continue;
            }
            
            if(digits[i] + 1 == 10) {
                digits[i] = 0;
                carry++;
            } else {
                digits[i]++;
                carry = 0;
                break;
            }
        }
        
        if(carry == 0) {
            return digits;
        } else {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = carry;
            System.arraycopy(digits, 0, newDigits, 1, digits.length-1);
            return newDigits;
        }
        
    }
}
