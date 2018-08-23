/*
 * Name: First Unique Character in a String
 * Date: 08/23
 * bigEyeChink
 */
// Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

// s = "leetcode"
// return 0.

// s = "loveleetcode",
// return 2.



动笔前: 第一种想法是使用 recursion, 但是没办法解决 index的问题
        第二种方法 利用Map 不重复性, 但是因为没有想清楚order的问题, 实际 order基于 原来的 String 而不是 利用Map

class Solution {
    public int firstUniqChar(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            //官方包 用的put
            map.put(s.charAt(i),map.containsKey(s.charAt(i))? map.get(s.charAt(i)) + 1 : 1);
            // 这里学到一种新的格式: condition判断语句? ture的值 : false的值
        }
        
        // 全部加入到map中记次数以后  按照 string原来的顺序!!!! 找第一个 value是1 的
        for(int i = 0; i < s.length(); i++){
            if(map.get(s.charAt(i)) == 1){
                return i;
            }
        }
        
        return -1;
        //默认return -1;
    }
}


最优解法:
class Solution {
    public int firstUniqChar(String s) {
        //null 不确定需不需要考虑  length = 0 不影响结果
       if(s == null || s.length() == 0 ){
        return -1;
       }

       // 这里也可以用 s.length()+1 但是用Integer max 只是简单的复制值  对计算机来说 大小没区别  直接复制更快速
       int idx = Integer.MAX_VALUE;

       // 利用小技巧   char 本质是数字
       for(char ch = 'a', ch <= 'z',++ch){
        int id = s.indexOf(ch);
        // 不知道这个lastIndexOf 这个函数
        // 即使知道也不一定 能考虑到 max_value的替换值
        if(id != -1 && id == s.lastIndexOf(ch) && id < idx) idx = id;
       }
       return idx == Integer.MAX_VALUE? -1 : idx;
    }
}


小结: 
考虑的方向还是单一
遇到的函数不够多 
考虑计算效率 而不是数值的大小
新的简化语句 坚持使用

