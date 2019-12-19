import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 *
 * https://leetcode-cn.com/problems/3sum-closest/description/
 *
 * algorithms
 * Medium (41.60%)
 * Likes:    304
 * Dislikes: 0
 * Total Accepted:    59K
 * Total Submissions: 140K
 * Testcase Example:  '[-1,2,1,-4]\n1'
 *
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target
 * 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * 
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * 
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 * 
 * 
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-2; i++){
            int lo = i + 1, hi = nums.length-1;
            while(lo < hi){
                int tmpSum = nums[i] + nums[lo] + nums[hi];
                if(Math.abs(tmpSum - target) < Math.abs(result - target)){
                    result = tmpSum;
                }
                if(tmpSum < target){
                    lo++; //小于target，头指针右移
                }else if(tmpSum > target){
                    hi--; //大于target，尾指针左移
                }else {
                    return result;
                }
            }
        }
        return result;
    }
}
// @lc code=end

