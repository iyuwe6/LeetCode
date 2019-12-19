/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第N个节点
 *
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/description/
 *
 * algorithms
 * Medium (35.33%)
 * Likes:    615
 * Dislikes: 0
 * Total Accepted:    99.2K
 * Total Submissions: 270.8K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 
 * 示例：
 * 
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 
 * 
 * 说明：
 * 
 * 给定的 n 保证是有效的。
 * 
 * 进阶：
 * 
 * 你能尝试使用一趟扫描实现吗？
 * 
 */

// @lc code=start
//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    //两次遍历
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        //指向第一个节点的头指针
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length = 0;
        ListNode first = head;
        //计算链表长度
        while(first != null){
            length++;
            first = first.next;
        }
        //计算从前往后在哪个位置删节点
        length -= n;
        first = dummy;
        while(length > 0){
            length--;
            first = first.next;
        }
        //删除节点
        first.next = first.next.next;
        //返回第一个节点
        return dummy.next;
    }

    //单次遍历，快慢指针
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        //指向第一个节点的头指针
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        //第一个指针先移动n个节点，保证两个指针始终间隔n个节点
        for(int i = 1; i <= n + 1; i++){
            first = first.next;
        }
        //将第一个指针移动到末尾，则第二个指针指向倒数第n个节点
        while(first != null){
            first = first.next;
            second = second.next;
        }
        //删除节点
        second.next = second.next.next;
        //返回第一个节点
        return dummy.next;
    }
}
// @lc code=end

