
/*
 * Name: Plus One
 * Date: 07/20
 * bigEyeChink
 */
// Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
// The digits are stored such that the most significant digit is at the head of the list, and each 
// element in the array contain a single digit.
// You may assume the integer does not contain any leading zero, except the number 0 itself.

//Ex1 
//Input: [1,2,3]
//Output: [1,2,4]
//Explanation: The array represents the integer 123.

//Ex2
//Input: [4,3,2,1]
//Output: [4,3,2,2]
//Explanation: The array represents the integer 4321.



// 这个问题比较难处理的点 第一是进位的处理 第二是 99 变成 100  对了一位数 显然要新建array 
// 来解决array 长度不能改变的问题
// 加法手算的时候 是从右侧开始加 不停地进位 到没有为止 
// 因为最后return 一个array  在最后一位计算完之前 没有办法知道结果一共有几位 
// 所以在拿出array 到放入新array 之间 需要一个中间介质: 有顺序 越简单越好 自然是stack合适
// 将array最后一位放入 stack 观察进位  carry 向前 直到结束  
// 再用stack size build新的array loop进每一位数字
class MySolution {
    public int[] plusOne(int[] digits) {
        Stack<Integer> stack = new Stack<>();
        int last = digits[digits.length - 1 ]; // 可被简化 见简化版
        int carry = 0;
        if(last == 9){
            carry++;
            last = 0; 
        }else{
            last++;
        }
        stack.push(last);
        for (int i = digits.length - 2; i >= 0 ; i-- ){//递减for i  注意条件
            int temp = digits[i] + carry;
            carry = 0;
            if(temp == 10){
                temp = 0;
                carry++;
            }
            stack.push(temp);
        }
        
        if(carry != 0){
            stack.push(carry);
        }
        int[] res = new int[stack.size()]; // stack的大小函数是size 不是length 与OsuC 不一样
        for (int i = 0; !stack.isEmpty(); i++){ //由于pop 函数 stack.size 在这里不能作为loop 停止条件
        	res[i] = stack.pop();
        }
        return res;
    }
}


//改进版
class Solution {
    public int[] plusOne(int[] digits) {
        Stack<Integer> stack = new Stack<>();
        digits[digits.length - 1 ] += 1; //在array 中加1    注意int 没有Aliasing
        //错误: int last = digits[digits.length - 1 ] + 1;
        int carry = 0;
        for (int i = digits.length - 1; i >= 0 ; i-- ){ 
            int temp = digits[i] + carry;
            carry = 0;
            if(temp == 10){
                temp = 0;
                carry++;
            }
            stack.push(temp);
        }
        
        if(carry != 0){
            stack.push(carry);
        }
        int[] res = new int[stack.size()]; 
        for (int i = 0; !stack.isEmpty(); i++){
        	res[i] = stack.pop();
        }
        return res;
    }
}

//标准答案

//这个答案做了一个简单分类 , 使得他更合适 +1 
// 因为是加一 所以length变化 只要所有数字全部是9
// 并且 有任意一个不是9 之后就不会产生进位的问题
// 总体分为 全部是9 和 其他 
// 1. 全是9:  
// 结果必然是10000....
// 创建array长度是原长度+1  利用默认 00000 只把第一位改成1 即可
// 2. 其他
// 因为有一个不是9 就可以停止了  因此 用 for nest if nest break
// 是9的话 就此位归零 下一位还是就继续加一
public int[] plusOne(int[] digits) {
        
    int n = digits.length;
    for(int i=n-1; i>=0; i--) {
        if(digits[i] < 9) {
            digits[i]++;
            return digits;
        }
        
        digits[i] = 0;
    }
    
    int[] newNumber = new int [n+1];
    newNumber[0] = 1;
    
    return newNumber;
}

// 小结: 
// 问题没有特殊化的去考虑, 想到了长度变化,但是没有继续向下考虑 什么时候回变化长度 
// 变化长度是不是个特殊现象.
// 即使使用稍微复杂的办法,没有完全掌握官方一些方法的具体参数 
// 经常犯错的动态判定条件的错误仍然在犯 
