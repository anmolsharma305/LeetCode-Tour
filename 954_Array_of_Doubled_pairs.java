/*@Author: Anmol Kumar Sharma

Problem: Array of Doubled Pairs
Problem Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/614/week-2-august-8th-august-14th/3877/

Reference Link: https://www.youtube.com/watch?v=tbq0fnZ-IhM
*/

class Solution {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> freqMap = new TreeMap<>();
        
        for(int element: arr){
            freqMap.put(element, freqMap.getOrDefault(element, 0) + 1);
        }
        
        for(int element: freqMap.keySet()){
            if(freqMap.get(element) == 0) continue;
            
            int target = element < 0 ? element / 2 : element * 2;
            
            //add check 
            if(element < 0 && element % 2 != 0) return false;
            
            if(freqMap.get(element) > freqMap.getOrDefault(target, 0)) return false;
            
            freqMap.put(target, freqMap.get(target) - freqMap.get(element));
        }
        return true;
    }
}
