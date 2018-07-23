/*
 * Name: Reverse Vowels of a String
 * Date: 07/22
 * bigEyeChink
 */
// Write a function that takes a string as input and reverse only the vowels of a string.

// Example 1:
// Given s = "hello", return "holle".

// Example 2:
// Given s = "leetcode", return "leotcede".

// Note:
// The vowels does not include the letter "y".


//origin 
// 利用递归的方法向内 一部分一部分的换
class Solution {
    public String reverseVowels(String s) {
        char[] charA  = s.toCharArray();
        charA = helper(charA);
        return charA.toString();
    }
    
     public char[] helper(char[] charA){
         String vowels = "aeiou";
         int fInd = -1;
         int sInd = -1;
         if(charA.length > 1){
            for (int i = 0;  i < charA.length;i++ ){
                if (vowels.indexOf(charA[i]) != -1){
                    fInd = i;
                    break;
                }
            }    
            for(int i = charA.length -1; i >= 0 ; i--){
                if (vowels.indexOf(charA[i]) != -1){
                    sInd = charA.length - i -1;
                    break;
                }
                
            }
            if(fInd != sInd){
                char temp = charA[fInd];
                charA[fInd] = charA[sInd];
                charA[sInd] = charA[fInd];
                String string = charA.toString();
                string = reverseVowels(string.substring(fInd,sInd + 1));
                for(int i = 0 ; i < string.length(); i++ ){
                    charA[i + fInd] = string.charAt(i);
                }
            }
            return charA;
         }
         else{
             return charA;
         }
     }
    
}


//最优解法
public class Solution {
public String reverseVowels(String s) {
    if(s == null || s.length()==0) return s;
    // 大小写都要包括
    String vowels = "aeiouAEIOU";
    //toCharArray 不是 toArray 
    char[] chars = s.toCharArray();
    int start = 0;
    int end = s.length()-1;
    while(start<end){
        //String本身有contains的函数
        while(start<end && !vowels.contains(chars[start]+"")){
            start++;
        }
        
        while(start<end && !vowels.contains(chars[end]+"")){
            end--;
        }
        
        char temp = chars[start];
        chars[start] = chars[end];
        chars[end] = temp;
        
        start++;
        end--;
    }
    return new String(chars);
}

// 小结
// 不要把问题想的复杂  过分的依赖递归 
// String 是不可变的 想到了 这点还好
// 脑子想问题 还是不能想的很具体 这题要多复习 很经典 

