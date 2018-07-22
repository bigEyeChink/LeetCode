
/*
 * Name: Power of Three
 * Date: 07/21
 * bigEyeChink
 */

// Given an integer, write a function to determine if it is a power of three.

// Example 1:

// Input: 27
// Output: true
// Example 2:

// Input: 0
// Output: false
// Example 3:

// Input: 9
// Output: true
// Example 4:

// Input: 45
// Output: false
// Follow up:
// Could you do it without using any loop / recursion?

//很简单的解决方法 相当于不停地除以3  mod 是不是为零 
// 同样暴露问题也很大  没有考虑 0 和负数的问题 
// 在power of two 因为用了特殊方法  没有暴露出这个问题
class Solution {
    public boolean isPowerOfThree(int n) {
        if(n == 1 ){
            return true;
        }else if(n < 1 ){
            return false;
        }
        else{
            if(n % 3 == 0){
                return isPowerOfThree(n / 3);
            }
            return false;
        }
        
    }
}


// 最优解法:
// 利用基本原理 3的n次方 必然能整除 3的 n -1 次方 
// 而在int的值域内 最大值为 3^19 = 1162261467 
// 实际上是一种投机取巧的解法 但是也需要一定头脑 
// 需要积累这种方式


class Solution {
public:
    bool isPowerOfThree(int n) {
       return n > 0 && (1162261467 % n == 0);
    }
}



// 推荐解法:
log 暂时没有弄懂 log的运算比出发要快吗?



// 小结:
// 还是考虑的问题 不够细节
// 对于值域的理解不够深刻 一个是testcase 的值域  一个是带入值的值域妙用