/*
 * Name: Valid Parentheses
 * Date: 07/19
 * bigEyeChink
 */

//Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
//determine if the input string is valid.
//
//An input string is valid if:
//
//    1.Open brackets must be closed by the same type of brackets.
//    2.Open brackets must be closed in the correct order.
//Note that an empty string is also considered valid.

// Ex 1
//Input: "()"
//Output: true

// Ex 2
//Input: "()[]{}"
//Output: true

// Ex 3
//Input: "([)]"
//Output: false

// Ex 4
//Input: "{[]}"
//Output: true

/*
 * 看到题目我首先想到的是Context free grammer 
 * 拿着括号的一半 去找另一半 一对括号中间的的东西按照递归的方法处理
 * 没有抓到括号的而本质 ———— 前半个括号出现的顺序是无所谓的，但是每
 * 后半个括号 都要按照前半个括号出现顺序的倒序出现
 * 到这里基本上 因为倒序 就可以自然而然的想到 后入先出 Stack 是最合适的数据结构
 */
class Solution {

    public boolean isValid(String s) {

        Stack<Character> chars = new Stack<Character>();
        // String 在java中 不可直接使用for each loop
        // 但是Array 可以   toCharArray 函数 方便转化
        for(char c : s.toCharArray()){
            if( c == '('){
                chars.push(')');
            }
            else if (c == '['){
                chars.push(']');
            }
            else if (c == '{'){
                chars.push('}');
            }
            else{
            	// isEmpty 用来预防后半括号缺少的情况 
            	// 注意！ isEmpty 应该放在pop之前 Java中房顶顺序受影响 
            	// 不然应该写成 nest If
                if(chars.isEmpty() || chars.pop() != c){
                    return false;
                }
            }
        }
        // return 不能直接返回ture 防止之后后半个括号的情况发生  
    return chars.isEmpty();
        
    }
}

// 边界问题仍然欠缺考虑的精细程度 
// 对Stack的应用情况没有经验  盲目迷信递归
// 具体的语法不熟悉 String 没有for each  判定顺序等