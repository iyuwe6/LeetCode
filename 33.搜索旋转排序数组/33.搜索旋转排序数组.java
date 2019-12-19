/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 *
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (36.12%)
 * Likes:    448
 * Dislikes: 0
 * Total Accepted:    59.8K
 * Total Submissions: 164.9K
 * Testcase Example:  '[4,5,6,7,0,1,2]\n0'
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * 
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 
 * 你可以假设数组中不存在重复的元素。
 * 
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 
 * 示例 1:
 * 
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 
 * 
 * 示例 2:
 * 
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 * 
 */

// @lc code=start
class Solution {

    int [] nums;
    int target;

    //寻找旋转节点下标
    public int find_rotate_index(int left, int right) {
        //未旋转情况
        if (nums[left] < nums[right]) return 0;
  
        while (left <= right) {
            int pivot = (left + right) / 2;
            if (nums[pivot] > nums[pivot + 1]){
                return pivot + 1;
            }else {
                if (nums[pivot] < nums[left]){
                    right = pivot - 1;
                }else{
                    left = pivot + 1;
                }
            }
        }
        return 0;
    }
  
    public int search(int left, int right) {
        //二分查找
        while (left <= right) {
            int pivot = (left + right) / 2;
            if (nums[pivot] == target){
                return pivot;
            }else {
                if (target < nums[pivot]){
                    right = pivot - 1;
                }else{
                    left = pivot + 1;
                }
            }
        }
        return -1;
    }
  
    public int search1(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        
        int n = nums.length;
        if (n == 0) return -1;
        if (n == 1) return this.nums[0] == target ? 0 : -1;
        
        int rotate_index = find_rotate_index(0, n - 1);
        
        //目标值正好是旋转点
        if (nums[rotate_index] == target) return rotate_index;
        //旋转点为0，即数组未旋转
        if (rotate_index == 0) return search(0, n - 1);
        
        //目标值小于第一个节点，则目标值位于旋转的右边一段
        if (target < nums[0]){
            return search(rotate_index, n - 1);
        }else {
            //目标值大于等于第一个节点，则目标值位于旋转的左边一段
            return search(0, rotate_index);
        }
    }

    public int search2(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while(start < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] >= nums[start]){
                if(nums[start] <= target && target < nums[mid]){
                    end = mid==0 ? mid:mid-1;
                }else{
                    start = mid + 1;
                }
            }else {
                if(target > nums[mid] && target <= nums[end]){
                    start = mid + 1;
                }else{
                    end = mid==0 ? mid:mid-1;
                }
            }
        }
        return -1;
    }
}
// @lc code=end

