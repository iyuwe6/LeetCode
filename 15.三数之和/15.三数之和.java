import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 *
 * https://leetcode-cn.com/problems/3sum/description/
 *
 * algorithms
 * Medium (23.86%)
 * Likes:    1583
 * Dislikes: 0
 * Total Accepted:    127.1K
 * Total Submissions: 515.6K
 * Testcase Example:  '[-1,0,1,2,-1,-4]'
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0
 * ？找出所有满足条件且不重复的三元组。
 * 
 * 注意：答案中不可以包含重复的三元组。
 * 
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 
 * 满足要求的三元组集合为：
 * [
 * ⁠ [-1, 0, 1],
 * ⁠ [-1, -1, 2]
 * ]
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length-2; i++){
            //跳过前后相同数字
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int lo = i + 1, hi = nums.length-1, sum = 0 - nums[i];
            while(lo < hi){
                if(nums[lo] + nums[hi] == sum){
                    res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    //跳过前后相同数字
                    while(lo < hi && nums[lo] == nums[lo+1]) lo++;
                    //跳过前后相同数字
                    while(lo < hi && nums[hi] == nums[hi-1]) hi--;
                    lo++;
                    hi--;
                }else if(nums[lo] + nums[hi] < sum) lo++; //小于0，头指针右移
                else hi--; //大于0，尾指针左移
            }
        }
        return res;
    }
}
// @lc code=end

