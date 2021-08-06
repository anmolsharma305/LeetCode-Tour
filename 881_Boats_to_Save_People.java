/*
@Author: Anmol Kumar Sharma

Problem: Boats to Save People
Problem: https://leetcode.com/problems/boats-to-save-people/
Time Complexity: O(NlogN), where N is number of people (i.e., size of array)
*/

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        
        int l = 0;
        int h = n-1;
        int result = 0;
        
        //soting the given array
        Arrays.sort(people);
        
        //applying two pointer appraoch
        
        while(l <= h) {
            
            //In to count how many boats were utilized
            //as boat can carry two people ans if sum of weight of these people is smaller
            //then or equal to limit then we send then using one boat.
            //if sum is greater then limit then we need to reduce the sum for that we need to 
            // remove the person having greater weight and send him in one boat 
            result++;
            if(people[l] + people[h] <= limit) l++;
            
            h--;
        }
        return result;
    }
}
