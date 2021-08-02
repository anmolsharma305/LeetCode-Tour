/*
@Author: Anmol Kumar Sharma

Problem: Integer to Roman
Problem Link: https://leetcode.com/problems/integer-to-roman/
*/

class Solution {
    public String intToRoman(int num) {
        
        Map<String, Integer> map = new LinkedHashMap();
        
        // adding elements into map
        map.put("M", 1000);
        map.put("CM", 900);
        map.put("D", 500);
        map.put("CD", 400);
        map.put("C", 100);
        map.put("XC", 90);
        map.put("L", 50);
        map.put("XL", 40);
        map.put("X", 10);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("I", 1);
        
        StringBuilder sb = new StringBuilder();
        
        for(Map.Entry<String, Integer> m : map.entrySet()) {
            
            while(num >= m.getValue()) {
                num = num - m.getValue();
                sb.append(m.getKey());
            }
        }
        return sb.toString();
        
        
    }
}
