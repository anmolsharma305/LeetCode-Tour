/*
@Author: Anmol Kumar Sharma
Problem: Add Binary 
Problem Link: https://leetcode.com/problems/add-binary/
*/
/*
Appraoch: 
    - We will need to add the bits from right -> left
        - We can implement a two pointer approach
            - One pointer 'i' will indicate our current location inside 'a'
            - One pointer 'j' will indicate our current location inside 'b'
        - In each of the iteration
            - We will be finding the sum of the bits located at these two pointers
            - We should note that when adding two bits
                - There may be 'carry' over
                    - So, we will need to account for 'carry'
        - Lets go over all of the possible
            - b1     b2    carry    sum
            - 1      1      1        3 - bit = 1, carry = 1
            - 1      1      0        2 - bit = 0, carry = 1
            - 1      0      1        2 - bit = 0, carry = 1
            - 1      0      0        1 - bit = 1, carry = 0
            - 0      1      1        2 - bit = 0, carry = 1
            - 0      1      0        1 - bit = 1, carry = 0
            - 0      0      1        1 - bit = 1, carry = 0
            - 0      0      0        0 - bit = 0, carry = 0
    - One of the side case is
        - The two input strings may not be the same length
            - This means when we process the bits
                - One of the pointers may go out of bound
                - When a pointer is out of bound
                    - We will default the value of the bit to 0

Answer
    - Create the following variables
        - i, our current index inside 'a', initially at the last index
        - j, our current index inside 'b', initially at the last index
        - carry, the current carry
        - result, StringBuilder to keep track our result
    - While 'i' OR 'j' is not out of bound (greater than or equal to 0)
        - Retrieve the current 'b1' from index 'i' inside 'a'
            - If 'i' is out of bound
                - We will default 'b1' to 0
            - decrement 'i'
        - Retrieve the current 'b2' from index 'j' inside 'b'
            - If 'j' is out of bound
                - We will default 'b2' to 0
            - decrement 'j'
        - Calculate the sum
            - sum = b1 + b2 + carry
        - If 'sum' is equal to 3 or 2
            - Then the 'carry' will be set to 1
        - Else
            - Set 'carry' to 0
        - If 'sum' is equal to '1' OR '3'
            - Append '1' to 'result'
        - Else
            - Append '0' to 'result'
    - If 'carry' is greater than 0
        - Append '1' to 'result'
    - Reverse 'result'
    - Return a string representation of 'result'

What is the Time and Space Complexity?
    - Time Complexity = O(n), where n is the length of the longer string
        - O(n), process all of the bits
    - Space Complexity = O(2 * n) = O(n), where n is the length of the longer string
        - O(2 * n), StringBuilder and resulting string
*/

class Solution {
    public String addBinary(String a, String b) {
        int i = a.length()-1, j = b.length()-1, carry = 0;
        
        StringBuilder result = new StringBuilder();
        
        while(i >= 0 || j >= 0) {
            int b1 = (i >= 0) ? Character.getNumericValue(a.charAt(i--)) : 0;
            int b2 = (j >= 0) ? Character.getNumericValue(b.charAt(j--)) : 0;
            
            int sum = b1 + b2 + carry;
            carry = (sum == 3 || sum == 2) ? 1 : 0;
            result.append((sum == 1 || sum == 3) ? 1 : 0);
        }
        
        if(carry > 0) result.append(1);
        return result.reverse().toString();
    }
}
