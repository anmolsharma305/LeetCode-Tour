/*
@Author: Anmol Kumar Sharma

Problem: Group Anagram
Problem Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/614/week-2-august-8th-august-14th/3887/

Time Complexity: O(N * len), where N is size of Array and len is the length of each array
Space Complexity: O(N)
*/

class Solution {
    private String buildKey(String s) {
        char[] keyChar = new char[26];
        for(char c: s.toCharArray()){
            keyChar[c - 'a']++;
        }
        return new String(keyChar);
    }
    
    public List<List<String>> groupAnagrams(String[] strs) {        
        if(strs == null || strs.length == 0) return new ArrayList<>();
        
        Map<String, List<String>> map = new HashMap<>();
        
        for(String s: strs) {
            String key = buildKey(s);
            List<String> l = map.getOrDefault(key, new ArrayList<>());
            l.add(s);
            map.put(key, l);
        }
        return new ArrayList<>(map.values());
    }
}
