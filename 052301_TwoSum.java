class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> numMap = new HashMap(); 
        // HashMap 有顺序
        int[] res = new int[2];
        for(int i = 0; i < nums.length; i++ ){
            numMap.put(nums[i],i);
            // put 加
        }
        
        for(int i = 0;i < nums.length;i++){
            if(numMap.containsKey(target - nums[i]) && numMap.get(target - nums[i]) != i){
                // 注意要求  不能为同一个数
                // get 函数
                res[0] = i;
                res[1] = numMap.get(target - nums[i]); 
            }
        }
        
        return res;
    }
}