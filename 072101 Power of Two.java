
/*
 * Name: Power of Two
 * Date: 07/21
 * bigEyeChink
 */

/*Given an integer, write a function to determine if it is a power of two.
 */

// Example 1:
// Input: 1
// Output: true 
// Explanation: 20 = 1

// Example 2:
// Input: 16
// Output: true
// Explanation: 24 = 16

// Example 3:
// Input: 218
// Output: false

class Solution {
    public boolean isPowerOfTwo(int n) {
        if(  n == 1 ){
            return true;
        }
        else{
            int last = n % 10;
            if(last == 2||last == 4||last == 6 || last == 8){
                return isPowerOfTwo(n / 2);
            }
            return false;
        }
        
    }
}