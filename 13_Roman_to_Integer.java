/*
@Author: Anmol Kumar Sharma

Problem: Roman to Integer
Problem Link: https://leetcode.com/problems/roman-to-integer/

Time Complexity: O(N), where N is the total no. of character in the Roman String.
*/

class Solution {
    public int romanToInt(String s) {
        if(s == null || s.length() == 0) return 0;
        
        Map<Character, Integer> map = new HashMap();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int result = 0;
        for(int i = 0; i < s.length()-1; i++){
            if(map.get(s.charAt(i)) >= map.get(s.charAt(i+1))) {
                result = result + map.get(s.charAt(i));
            }
            else {
                result = result - map.get(s.charAt(i));
            }
        }
        
        // Adding the value of last character in the result
        result = result + map.get(s.charAt(s.length() - 1));
        return result;
    }
}
