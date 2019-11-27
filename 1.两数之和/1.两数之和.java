import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */
class Solution {

    //HashMap一次循环
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int j = 0; j < nums.length; j++){
            int sub = target - nums[j];
            if(map.containsKey(sub)){
                return new int[]{map.get(sub), j};
            }
            map.put(nums[j], j);
        }
        return new int[2];
    }

    //HashMap两次循环
    public int[] twoSum1(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }

        for(int j = 0; j < nums.length; j++){
            int sub = target - nums[j];
            if(map.containsKey(sub) && sub != nums[j]){
                return new int[]{map.get(sub), j};
            }
        }
        return new int[2];
    }

    //暴力法
    public int[] twoSum2(int[] nums, int target){
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[2];
    }
}

