/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 *
 * https://leetcode-cn.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (26.92%)
 * Likes:    1483
 * Dislikes: 0
 * Total Accepted:    143.7K
 * Total Submissions: 519.6K
 * Testcase Example:  '"babad"'
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 
 * 示例 1：
 * 
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 
 * 
 * 示例 2：
 * 
 * 输入: "cbbd"
 * 输出: "bb"
 * 
 * 
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() <= 1){
            return s;
        }

        //记录最长回文子串起始位置
        int start = 0;
        //记录最长回文子串结束位置
        int end = 0;

        for(int i = 0; i < s.length(); i++){
            //以每个字符为中心向左右扩展，下面是"aba"这种奇数长度串
            int len1 = expandCenter(s, i, i);
            //以每个字符为中心向左右扩展，下面是"abba"这种偶数长度串
            int len2 = expandCenter(s, i, i+1);

            int len = Math.max(len1, len2);

            if(len > end - start){
                start = i - (len-1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start, end + 1);

    }

    private int expandCenter(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    }
}
// @lc code=end

