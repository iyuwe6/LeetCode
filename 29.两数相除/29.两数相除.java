/*
 * @lc app=leetcode.cn id=29 lang=java
 *
 * [29] 两数相除
 *
 * https://leetcode-cn.com/problems/divide-two-integers/description/
 *
 * algorithms
 * Medium (18.69%)
 * Likes:    233
 * Dislikes: 0
 * Total Accepted:    28.5K
 * Total Submissions: 150.7K
 * Testcase Example:  '10\n3'
 *
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * 
 * 示例 1:
 * 
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 
 * 示例 2:
 * 
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 
 * 说明:
 * 
 * 
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。本题中，如果除法结果溢出，则返回 2^31 − 1。
 * 
 * 
 */

// @lc code=start
class Solution {

    //普通相减法
    public int divide1(int dividend, int divisor) {
        if(dividend == 0){
            return 0;
        }
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }

        if(dividend > 0 && divisor < 0){
            dividend = -dividend;
            int re = 0;
            while(dividend <= divisor){
                dividend -= divisor;
                re ++;
            }
            return -re;
        }

        if(dividend > 0 && divisor > 0){
            int re = 0;
            while(dividend >= divisor){
                dividend -= divisor;
                re ++;
            }
            return re;
        }

        if(dividend < 0 && divisor > 0){
            divisor = -divisor;
            int re = 0;
            while(dividend <= divisor){
                dividend -= divisor;
                re ++;
            }
            return -re;
        }

        if(dividend < 0 && divisor < 0){
            int re = 0;
            while(dividend <= divisor){
                dividend -= divisor;
                re ++;
            }
            return re;
        }
        return 0;
    }

    //递归增量减法
    public int divide2(int dividend, int divisor) {
        if(dividend == 0 || divisor == 0){
            return 0;
        }
        long d1 = dividend, d2 = divisor;
        long result = divideLong(Math.abs(d1), Math.abs(d2));
        result = d1 * d2 < 0 ? -result : result;
        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE){
            return Integer.MAX_VALUE;
        }
        return (int)result;
    }

    public long divideLong(long d1, long d2){
        if(d1 < d2){
            return 0;
        }
        long sum = d2, num =1;
        //每次可以除去超过一半的被除数
        while(sum + sum <= d1){
            //除数不断翻倍
            sum+=sum;
            //1，2，4，8...
            num+=num;
        }
        return num+divideLong(d1-sum, d2);
    }

    //除数增量相减
    public int divide3(int dividend, int divisor) {
        //结果标志位
        boolean sign = (dividend > 0) ^ (divisor > 0);
        int result = 0;
        //被除数处理为负数
        if(dividend>0) {
            dividend = -dividend;
        }
        //除数处理为负数
        if(divisor>0) divisor = -divisor;
        while(dividend <= divisor) {
            int temp_result = -1;
            int temp_divisor = divisor;
            while(dividend <= (temp_divisor << 1)) {
                //除数越界处理
                if(temp_divisor <= (Integer.MIN_VALUE >> 1))break;
                //1, 2, 4, 8...
                temp_result = temp_result << 1;
                //除数指数递增
                temp_divisor = temp_divisor << 1;
            }
            dividend = dividend - temp_divisor;
            result += temp_result;
        }
        if(!sign) {
            if(result <= Integer.MIN_VALUE) return Integer.MAX_VALUE;
            result = - result;
        }
        return result;
    }
}
// @lc code=end

