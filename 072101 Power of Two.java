
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


//Orginal 
// 遇到这题的第一反应是原来写过的一个方法 利用递归 类似上课时候的 fastpower 
// 但是感觉效率可能还是不高 继续分析 发现2 的倍数 不会出现0 结尾的 
// 因为10 需要5 * 2 但是2的多少次方都不会5 结尾 
// 因此选择用 2 4 6 8 的判断  到底是 %2 == 0 快 还是我的方法快  需要验证

class Solution {
    public boolean isPowerOfTwo(int n) {
        // basecase 出错  第一遍写成了 n == 0
        // 不要相信的自己的直觉  再小的问题也要想到底 不要跳步骤
        if( n == 1 ){
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

// 最优解法
// running time 一样  但是这种方法应该还是少一步 2进制到10进制的转化 对于底层来说 
// 这种方法还是更快一点



// 二进制中 2 的n次方 为 1 10 100 1000 10000 ..... 
// bitCount 输出 n转化为二进制数字之后 1 的个数

class Solution {
    public boolean isPowerOfTwo(int n) {
        return (Integer.bitCount(n)==1 && n>0);
        
        
    }
}


// 小结:
// 根据二应该能联想二进制的特殊性 
// 注意积累类似知识  多利用底层
// 写代码不要省力气 验证到底再写