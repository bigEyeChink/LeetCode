/*
 * Name: Judge Route Circle
 * Number: 657
 * Date: 0905
 * bigEyeChink
 */


Probelm:
Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place.

The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a circle.

Example 1:

Input: "UD"
Output: true



Before Coding: 看到题目首先想到就是比较上下相等 和左右相等 利用最近用的比较多的map 来统计各个字母的值 是可行的办法



First try:


class Solution {
    public boolean judgeCircle(String moves) {
        Map<Character,Integer> map = new HashMap();
        for(int i =  0; i < moves.length(); i++){
            char ch = moves.charAt(i);
            map.put(ch, map.containsKey(ch)? (map.get(ch) + 1 ):1);
        }
        
        if(map.get('U') != map.get('D') || map.get('R') != map.get('L')){
            return false;
        }
        return true;
        
    }
}
/// 有一个test case 过不了  很奇怪  不知道问谁





Recommend Solution:
class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0; y = 0;
        for(char c : moves.toCharArray()){
        	//在for each 比 普通each 更快
        	switch(c){
        		//switch 比 if elseif 要快
        		case 'U':
        			y++;
        			break;
        		case 'D':
        			y--;
        			break;
        		case 'R':
        			x++;
        			break;
        		default:
        			x--;
        			break;
        	}
        }
        return x == 0 && y == 0;
}




Summary: 留给自己的思考的时间 仍然不够, 应该还是因为 有想法的时候比较稀少, 一有想法就比较激动,不会考虑想法是不是最好的
对比的时候 尽量减少变量的数量 这题中的  UD RL 可以总结到两个变量里面


