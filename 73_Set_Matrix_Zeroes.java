/*
@Author: Anmol Kumar Sharma
Problem: Set Matrix Zeroes
Problem Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/614/week-2-august-8th-august-14th/3888/
Time Complexity: O(M*N)
Space Complexity: O(M+N)
*/

/*
    Solution :- First create a boolean matrix for number of rows and another for number of columns
    Then iterate through the matrix if you find zero mark that row and column to zero in boolean matrix
    
    At the end of first iteration we have marked all the rows or columns that should be marked to zero.
    Now go throug the matrix one more time checking if either the current row or column is marked zero in boolean
    matrix if yes mark that value to zero
*/
class Solution {
    
    public void setZeroes(int[][] matrix) {
        boolean[] zeroRow = new boolean[matrix.length];
        boolean[] zeroColumn = new boolean[matrix[0].length];
        for (int i = 0 ; i < matrix.length ;i++){
            for(int j = 0 ; j < matrix[0].length ; j++){
                if(matrix[i][j] == 0){
                    zeroRow[i] = true;
                    zeroColumn[j] = true;
                }
            }
        }
        for (int i = 0 ; i < matrix.length ;i++){
            for(int j = 0 ; j < matrix[0].length ; j++){
                if(zeroRow[i] || zeroColumn[j]){
                    matrix[i][j] =0;
                }
            }
        }
    }
}
