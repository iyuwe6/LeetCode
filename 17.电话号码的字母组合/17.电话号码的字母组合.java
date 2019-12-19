import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 *
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (50.89%)
 * Likes:    510
 * Dislikes: 0
 * Total Accepted:    62.1K
 * Total Submissions: 120.3K
 * Testcase Example:  '"23"'
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * 
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 * 
 */

// @lc code=start
class Solution {

    //利用队列求解
    public List<String> letterCombinations1(String digits) {
        LinkedList<String> res = new LinkedList<>();
        // 使用数组模拟按键映射，这里可以换成HashMap
        String[] map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        if (digits.isEmpty())
            return res;
        res.add("");
        //最终结果的字符组合长度等于输入数字的长度
        while (res.peek().length() != digits.length()) {
            //取出队列头元素
            String temp = res.pop();
            //取出输入数字对应的字符组
            String value = map[digits.charAt(temp.length()) - '0'];
            for (char c : value.toCharArray())
//字符拼接，整个过程如下：
// "" + a = a
// "" + b = b
// "" + c = c
// a + d = ad
// a + e = ae
// a + f = af
// b + d = bd
// b + e = be
// b + f = bf
// c + d = cd
// c + e = ce
// c + f = cf
                res.add(temp + c);
        }
        return res;
    }

    //回溯法

    //一个映射表，第二个位置是"abc“,第三个位置是"def"。。。
	//这里也可以用map，用数组可以更节省点内存
	String[] letter_map = {" ","*","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	public List<String> letterCombinations2(String digits) {
		//注意边界条件
		if(digits==null || digits.length()==0) {
			return new ArrayList<>();
		}
		iterStr(digits, "", 0);
		return res;
	}
	//最终输出结果的list
	List<String> res = new ArrayList<>();
	
	//递归函数
	void iterStr(String str, String letter, int index) {
		//递归的终止条件，截取的字符下标与字符串长度相等
		//而用index记录每次遍历到字符串的位置，这样性能更好
		if(index == str.length()) {
			res.add(letter);
			return;
		}
		//获取index位置的字符，假设输入的字符是"234"
		//第一次递归时index为0所以c=2，第二次index为1所以c=3，第三次c=4
		//subString每次都会生成新的字符串，而index则是取当前的一个字符，所以效率更高一点
		char c = str.charAt(index);
		//map_string的下表是从0开始一直到9， c-'0'就可以取到相对的数组下标位置
		//比如c=2时候，2-'0'，获取下标为2,letter_map[2]就是"abc"
		int pos = c - '0';
		String map_string = letter_map[pos];
		//遍历字符串，比如第一次得到的是2，页就是遍历"abc"
		for(int i=0;i<map_string.length();i++) {
			//调用下一层递归
			iterStr(str, letter+map_string.charAt(i), index+1);
		}
	}
}
// @lc code=end

