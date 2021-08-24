/*
@Author: Anmol Kumar Sharma
Problem: Complex Number Multiplication
Problem Link: https://leetcode.com/problems/complex-number-multiplication/

Time Complexity: O(N) + O(M), N and M are length of complex numbers given in String form.
*/

/*
Intuition: 

* As Complex number contains two part real and Imaginary.
* whenever we multiply two complex Number they form another complex Number.

Let understand how complex number are multiplied:

num1 = a + bi;
num2 = c + di;

num1 * num2 = a * c + a * di + c * bi - b * d    (here b * d is negative because of i * i);
            = (a * c - b * d) - (a * di + b * ci);
above result will help us to reach the desired result;
*/

class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        //These arrays will contain real and imaginary part of a complex number.
        // arr[] : { realPart, imaginaryPart}
        int[] number1 = new int[2];
        int[] number2 = new int[2];
        
        number1 = extractPart(num1);
        number2 = extractPart(num2);
        
        //our logic that we have discussed
        int resRealPart = (number1[0] * number2[0]) - (number1[1] * number2[1]);
        int resImgPart = (number1[1] * number2[0]) + (number1[0] * number2[1]);
        
        String mul = resRealPart + "+" + resImgPart + "i";
        return mul;
    }
    
    // this function will extract the real and imginary part of given number
    public int[] extractPart(String num) {
        int i = 0;
        int realPart = 0;
        
        //take a boolean value to store whether the real part is negative or not
        boolean isNegReal = false;
        if(num.charAt(i) == '-') {
            isNegReal = true;
            i++;
        }
        
        //extracting real part till '+'
        while(num.charAt(i) != '+') {
            realPart = 10 * realPart + (num.charAt(i) - '0');
            i++;
        }
        
        //update if real part is negative
        if(isNegReal) {
            realPart = -realPart;
        }
        i++;
        
        //check for imginary part is negative or not
        boolean isNegImg = false;
        if(num.charAt(i) == '-'){
            isNegImg = true;
            i++;
        }
        
        //extract imginary part 
        int imgPart = 0;
        while(num.charAt(i) != 'i') {
            imgPart = 10 * imgPart + (num.charAt(i) - '0');
            i++;
        }
        
        //update if imaginary part is negative
        if(isNegImg) {
            imgPart = -imgPart;
        }
        
        return (new int[] {realPart, imgPart});
     }
}
