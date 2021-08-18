/*
@Author: Anmol Kumar Sharma
Problem: Decode Ways
Problem Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/615/week-3-august-15th-august-21st/3902/
*/
/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.

Solution : DP

because of '0' may exist in s, so calculate from rigth to left will igore invalid situtation
such as s="10", 

ways[i]=   0 if s.charAt(i)=='0'
           
           or 
          
           ways[i+1] if s.charAt(i)!='0',
           
           + ways[i+1]+ways[i+2] if s.charAt(i)=='1' || s.charAt(i)=='2' && s.charAt(i+1)<='6'
*/

public class Solution {
    public int numDecodings(String s) {
        if (s==null||s.length()==0){
            return 0;
        }
        
        // declare ways array with two extra space, because ways[i] also affect by ways[i+2]
        int[] ways=new int[s.length()+2];
        
        
        Arrays.fill(ways, 1);
        int i=s.length()-1;
        
        ways[i]=s.charAt(i)=='0'?0:1;
        
        for (i=i-1; i>=0; i--){
            if (s.charAt(i)=='0'){
                // if current digit is '0', so no mater what right is, current ways should be 0;
                ways[i]=0;
            }
            else{
               // if current digit is not '0', current ways should be ways[i+1]
               // because, for example s="12", i=0, ways[1]=1, then because current digit is not zero, so for
               // each situation of when i=1, the current i=0 should  be a valid way, 
                ways[i]=ways[i+1];
            
            
            // check is current digit with right 1 digit can be a valid situation,so in this situation only s.charAt(i)=='1'||
            // s.charAt(i)=='2' and s.charAt(i+1)<='6' can be valid situation, the ways[i] should + ways[i+2];
            
                if (i+2<ways.length && s.charAt(i)=='1'||s.charAt(i)=='2' &&s.charAt(i+1)<='6'){
                    ways[i]+=ways[i+2];
               }
            }
        }
        
        return ways[0];
    }
}
