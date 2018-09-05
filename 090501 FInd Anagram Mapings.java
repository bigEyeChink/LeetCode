/*
 * Name: Find Anagram Mappings
 * Date: 09/05
 * bigEyeChink
 */
// Given two lists Aand B, and B is an anagram of A. B is an anagram of A means B is made by randomizing the order of the elements in A.

// We want to find an index mapping P, from A to B. A mapping P[i] = j means the ith element in A appears in B at index j.

// These lists A and B may contain duplicates. If there are multiple answers, output any of them.

// For example, given

// A = [12, 28, 46, 32, 50]
// B = [50, 12, 32, 46, 28]
// We should return
// [1, 4, 3, 2, 0]
// as P[0] = 1 because the 0th element of A appears at B[1], and P[1] = 4 because the 1st element of A appears at B[4], and so on.
// Note:

// A, B have equal lengths in range [1, 100].
// A[i], B[i] are integers in range [0, 10^5].

动笔前: 这道题目和leetcode第一题 twosum 很相似, 都是循环在一个array 中查找想要的值, 方法也应该类似 利用map来储存index

最优解法:
class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        int[] res = new int[A.length];
        Map<Integer,Integer> map = new HashMap();
        for(int i = 0; i < A.length; i++){
            map.put(B[i], i);
        }
        for(int i =  0; i < A.length; i++){
            res[i] = map.get(A[i]);
        }
        return res;
        
    }
}

小结: 好多思想在题目中重复出现, map 来简化运算速度的同时 也增加了运算空间, 必备算法之一  避免n^2 的出现