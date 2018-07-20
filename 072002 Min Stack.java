
/*
 * Name: Min Stack
 * Date: 07/20
 * bigEyeChink
 */

/*Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 *push(x) -- Push element x onto stack.
 *pop() -- Removes the element on top of the stack.
 *top() -- Get the top element.
 *getMin() -- Retrieve the minimum element in the stack.
 */

// Example:
// MinStack minStack = new MinStack();
// minStack.push(-2);
// minStack.push(0);
// minStack.push(-3);
// minStack.getMin();   --> Returns -3.
// minStack.pop();
// minStack.top();      --> Returns 0.
// minStack.getMin();   --> Returns -2.

//Origin Solution
// 设计class 首先想到的是 Osu中Stack 用ListNode编写的 而且单向读取符合listNode特点
// 因为需要min 所以想到了 创建一个指针 指向最小的那个node  在push的时候进行改变  
// 但是没有考虑到 pop的正好是min 这个node时 min 指向谁
// 发现这个问题后想到的第一个解决方法很自然  也与正确方法很类似了: 用个新的指针指向上一个min
// 但是连续remove min的问题没法解决
class MinStack {

    /** initialize your data structure here. */
    private Node min;
    private Node top;
    private Node pre;
    private Node lastMin;
    // nested Class 是private
    private class Node {
        int val;
        Node next;
        Node(int x) {
            this.val = x;
        }
    }
    
    
    public MinStack() {
        
        this.min = new Node(0);
        this.pre = this.min;
    }
    
    public void push(int x) {
       
        Node newN = new Node(x);
         if(pre.next == null){
            this.min = newN;
           
        }
        else{
            if(this.min.val > x){
                this.lastMin = this.min;
                this.min = newN;
                
            }
             newN.next = top;
        }
        //指针混乱  多画图 
        pre.next = newN;
        top = newN;
    }
    
    public void pop() {
        Node remove = this.top;
        if(remove.val == this.min.val){
            this.min = this.lastMin;
        }
        this.top = remove.next;
    }
    
    public int top() {
        return this.top.val;
    }
    
    public int getMin() {
        return this.min.val;
    }
}


//参考后 改进的答案
// 答案与我的相比,想法类似 也是存储上一次的min
//我选择了存在private 变量里面,数量有限,没有办法增加个数
// 答案选择存node 里面 数量可以与数据个数变化
class MinStack {

    /** initialize your data structure here. */
    private Node top;
    private class Node {
        int val;
        Node next;
        int min;
        Node(int x) {
            this.val = x;
            this.min = x;
            next = null;
        }
    }
    
    
    public MinStack() {
    }
    
    public void push(int x) {
       
        Node temp = new Node(x);
         if(top == null){
             this.top = temp;
        }else{
             temp.next = this.top;
             top = temp;
             //调用 Math min 速度更快 原因未知
             temp.min = Math.min(x,temp.next.min);
         }
    }
    
    public void pop() {
        this.top = this.top.next;
    }
    
    public int top() {
        return this.top.val;
    }
    
    public int getMin() {
        return this.top.min;
    }
}
// 小结:
// 分析问题还是不够完整 
// 心态太极了 老不把全部细节考虑完全 
// 依赖于让电脑运行出错后在用出错的结果找bug 而不是一开始就在心理模拟好 
// 把bug自己找一遍 在开始动笔
// 仍旧依赖Osu 的东西太多了 需要见跟更多的代码 