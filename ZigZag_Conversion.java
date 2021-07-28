/*
@Author: Anmol Kumar Sharma
Problem: ZigZag Conversion
Problem Link: https://leetcode.com/problems/zigzag-conversion/
*/

class Solution {
    public String convert(String s, int numRows) {
        int len = s.length();
        
        if(numRows > len || numRows <= 1) return s;
        
        char[] zigzagChars = new char[len];
        int count = 0;
        
        int interval = 2 * numRows - 2;
        for(int i = 0; i < numRows; i++){
            int step = interval - 2 * i;
            for(int j = i; j < len; j += interval) {
                zigzagChars[count] = s.charAt(j);
                count++;
                if(step > 0 && step < interval && j + step < len){
                    zigzagChars[count] = s.charAt(j + step);
                    count++;
                }
            }
        }
        return new String(zigzagChars);
    }
}
