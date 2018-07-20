/*
 * Name: Add Two Numbers
 * Date: 07/19
 * bigEyeChink
 */

//You are given two non-empty linked lists representing two non-negative integers.
//The digits are stored in reverse order and each of their nodes contain a single
//digit. Add the two numbers and return it as a linked list.
//

//You may assume the two numbers do not contain any leading zero, except the number 0 itself.

// Ex：
//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 0 -> 8
//Explanation: 342 + 465 = 807.
public class AddTwoNumbers {

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
    }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        	// 没有想新建一个指针  如果用原来的l1 自带的指针 以后l1 就没有办法被第二次读取了 
        	// 函数中如果调用函数外的 Listnode 应该改创建一个新的指针
            ListNode ln1 = l1;
            ListNode ln2 = l2;
            int carry = 0;
            // 也是指针的问题，需要两个指针 一个用来添加node 即sum 
            //另外一个用来读取 p-->re
            ListNode pre = new ListNode(0);
            //pre 在这个位置 必须要先有个node 由于没有办法得到retuern的第一位数字是多少 
            //所以就先用 0 作为首位 return的时候 不返回第一位
            ListNode sum = pre;
            // 考虑两个数字 长度一不一样的问题
            // while or 判定 里面连个 if  解决同类问题值得借鉴
            while (ln1 != null || ln2 != null) {
                int digit = 0;
                if (ln1 != null) {
                    digit += ln1.val;
                    ln1 = ln1.next;
                }
                if (ln2 != null) {
                    digit += ln2.val;
                    ln2 = ln2.next;
                }
                digit += carry;
                // 除法符号和mod符号的用法 
                // 注意digit 处以之后  digit 本身不变化 不要与 OSU NN 混淆
                carry = digit / 10;
                sum.next = new ListNode(digit % 10);
                // 写这题的时候 长时间没解决的就是这个问题  没有把 sum的指针往后移 当在next
         		// 加完数字之后
                sum = sum.next;

            }
            // 判断之后是不是仍然有余数
            if (carry > 0) {
                sum.next = new ListNode(carry);
            }
            return pre.next;
            // 见46 行
        }
    }

}
