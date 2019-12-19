/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 *
 * https://leetcode-cn.com/problems/palindrome-number/description/
 *
 * algorithms
 * Easy (56.54%)
 * Likes:    830
 * Dislikes: 0
 * Total Accepted:    206.3K
 * Total Submissions: 364K
 * Testcase Example:  '121'
 *
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 
 * 示例 1:
 * 
 * 输入: 121
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 
 * 
 * 示例 3:
 * 
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 
 * 
 * 进阶:
 * 
 * 你能不将整数转为字符串来解决这个问题吗？
 * 
 */

// @lc code=start
class Solution {
    public boolean isPalindrome1(int x) {
        boolean result = false;

        //负数肯定不是回文数
        if(x < 0){
            return false;
        }
        //0是回文数
        if(x == 0){
            return true;
        }
        //末位为0不是回文数
        if(x % 10 == 0){
            return false;
        }

        //保存原数
        int in = x;
        //存储反转后的数
        int re = 0;

        while(x > 0){
            re = re * 10 + x % 10;
            x /= 10;
        }

        //比较反转前后结果
        if(re == in){
            result = true;
        }

        return result;
    }

    public boolean isPalindrome2(int x) {
        if(x < 0 || (x % 10 == 0 && x != 0)){
            return false;
        }

        int revertedNumber = 0;
        while(x > revertedNumber){
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        return x == revertedNumber || x == revertedNumber/10;
    }
}
// @lc code=end

