/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 *
 * https://leetcode-cn.com/problems/longest-common-prefix/description/
 *
 * algorithms
 * Easy (34.65%)
 * Likes:    785
 * Dislikes: 0
 * Total Accepted:    155.8K
 * Total Submissions: 439.7K
 * Testcase Example:  '["flower","flow","flight"]'
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 
 * 如果不存在公共前缀，返回空字符串 ""。
 * 
 * 示例 1:
 * 
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 
 * 
 * 示例 2:
 * 
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 
 * 
 * 说明:
 * 
 * 所有输入只包含小写字母 a-z 。
 * 
 */

// @lc code=start
class Solution {

    //依次遍历比较每一个字符串的每一位字符
    public String longestCommonPrefix1(String[] strs) {

        if(strs.length == 0){
            return "";
        }

        String prefix = "";
        int len1 = strs.length;
        int len2 = strs[0].length();
        boolean bool = true;
        for(int i = 0; i < len2; i++){
            char ch = strs[0].charAt(i);
            for(int j = 1; j < len1; j++){
                if(strs[j].length() > i && strs[j].charAt(i) == ch){
                    bool = true;
                }else{
                    bool = false;
                    break;
                }
            }
            if(bool == true){
                prefix += ch;
            }else{
                break;
            }
        }
        return prefix;
    }

    //依次求相邻字符串的最长公共前缀
    public String longestCommonPrefix2(String[] strs) {

        if(strs.length == 0){
            return "";
        }

        //初始化前缀位第一个字符串
        String prefix = strs[0];

        for(int i = 1; i < strs.length; i++){

            //关键点
            //例如， abc, abde，此时indexOf的结果为-1，则将abc截取最后一位，
            // ab, abde，此时indexOf结果为0，满足，prefix改为ab，即这两个字符串的最长公共前缀
            //又例如，bc, abcd,此时indexof为1，截取bc最后一位，indexOf的结果始终为1，直至bc截取为空字符串
            //那么就表明这两个字符串没有公共前缀，则整个字符串组不存在公共前缀，直接返回“”
            //综上，只有indexOf的结果为0时，才有公共前缀
            while(strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0, prefix.length()-1);
                if(prefix.isEmpty()){
                    return "";
                }
            }
        }
        return prefix;
    }

    //分治
    public String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) return "";    
            return longestCommonPrefix(strs, 0 , strs.length - 1);
    }
    
    private String longestCommonPrefix(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        }
        else {
            int mid = (l + r)/2;
            String lcpLeft =   longestCommonPrefix(strs, l , mid);
            String lcpRight =  longestCommonPrefix(strs, mid + 1,r);
            return commonPrefix(lcpLeft, lcpRight);
       }
    }
    
    String commonPrefix(String left,String right) {
        int min = Math.min(left.length(), right.length());       
        for (int i = 0; i < min; i++) {
            if ( left.charAt(i) != right.charAt(i) )
                return left.substring(0, i);
        }
        return left.substring(0, min);
    }

    //二分查找
    public String longestCommonPrefix4(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        int minLen = Integer.MAX_VALUE;
        for (String str : strs)
            minLen = Math.min(minLen, str.length());
        int low = 1;
        int high = minLen;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (isCommonPrefix(strs, middle))
                low = middle + 1;
            else
                high = middle - 1;
        }
        return strs[0].substring(0, (low + high) / 2);
    }
    
    private boolean isCommonPrefix(String[] strs, int len){
        String str1 = strs[0].substring(0,len);
        for (int i = 1; i < strs.length; i++)
            if (!strs[i].startsWith(str1))
                return false;
        return true;
    }
}
// @lc code=end

