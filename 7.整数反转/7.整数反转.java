/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 *
 * https://leetcode-cn.com/problems/reverse-integer/description/
 *
 * algorithms
 * Easy (33.00%)
 * Likes:    1484
 * Dislikes: 0
 * Total Accepted:    228.1K
 * Total Submissions: 686.4K
 * Testcase Example:  '123'
 *
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 
 * 示例 1:
 * 
 * 输入: 123
 * 输出: 321
 * 
 * 
 * 示例 2:
 * 
 * 输入: -123
 * 输出: -321
 * 
 * 
 * 示例 3:
 * 
 * 输入: 120
 * 输出: 21
 * 
 * 
 * 注意:
 * 
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回
 * 0。
 * 
 */

// @lc code=start
class Solution {

    //用long类型存储转换后的结果，判断是否溢出
    public int reverse1(int x) {
        //flag标记是否为正数
        boolean flag = true;
        //负数转为正数处理
        if(x < 0){
            x = -x;
            flag = false;
        }

        //输入为0的情况
        if(x == 0){
            return 0;
        }

        //处理原数末尾为0，反转后头部为0丢弃的情况
        while(x % 10 == 0){
            x /= 10;
        }

        long result = 0;
        //从末尾按位取余
        while(x > 0){
            result = result * 10 + x % 10;
            //反转后结果溢出处理
            if(result > Integer.MAX_VALUE){
                return 0;
            }
            x /= 10;
        }
        
        if(flag){
            return (int)result;
        }else{
            //负数前面加负号
            return -(int)result;
        }

    }

    //用StringBuilder存储结果，依据转Int异常判断溢出
    public int reverse2(int x) {
        StringBuilder sBuilder = new StringBuilder();
        //负数转为正数处理
        if(x < 0){
            x = -x;
            sBuilder.append('-');
        }

        //反转操作
        while(x > 0){
            sBuilder.append(x % 10);
            x /= 10;
        }

        try {
            return Integer.parseInt(sBuilder.toString());
        } catch (Exception e) {
            //异常包含x为0和反转后溢出两种情况
            return 0;
        }
    }
}
// @lc code=end

