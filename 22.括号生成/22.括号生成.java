import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 *
 * https://leetcode-cn.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (71.64%)
 * Likes:    645
 * Dislikes: 0
 * Total Accepted:    58.6K
 * Total Submissions: 80.8K
 * Testcase Example:  '3'
 *
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 
 * 例如，给出 n = 3，生成结果为：
 * 
 * [
 * ⁠ "((()))",
 * ⁠ "(()())",
 * ⁠ "(())()",
 * ⁠ "()(())",
 * ⁠ "()()()"
 * ]
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis1(int n) {
        List<String> res = new ArrayList<>();
        //n=0处理
        if(n == 0){
            return res;
        }
        //执行DFS，查找可能的结果
        dfs("", n, n, res);
        return res;
    }

    //curStr当前递归的结果，left剩余的左括号，right剩余的右括号，res最终的结果集
    private void dfs(String curStr, int left, int right, List<String> res){
        //递归终止的条件，左右括号都用完
        if(left == 0 && right == 0){
            res.add(curStr);
            return;
        }

        //左括号未用完
        if(left > 0){
            dfs(curStr + "(", left - 1, right, res);
        }
        //右括号未用完，且需始终保证使用的左括号比右括号多
        if(right > 0 && left < right){
            dfs(curStr + ")", left, right - 1, res);
        }
    }

    public List<String> generateParenthesis2(int n) {
        List<String> res = new ArrayList<>();
        //n=0处理
        if(n == 0){
            res.add("");
        }else {
            for( int c = 0; c < n; ++c){
                for(String left: generateParenthesis2(c)){
                    for(String right: generateParenthesis2(n-1-c)){
                        res.add("(" + left + ")" + right);
                    }
                }
            }
        }
        return res;
    }
}
// @lc code=end

