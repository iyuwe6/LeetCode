/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
 *
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/description/
 *
 * algorithms
 * Easy (57.01%)
 * Likes:    750
 * Dislikes: 0
 * Total Accepted:    150.2K
 * Total Submissions: 256.2K
 * Testcase Example:  '[1,2,4]\n[1,3,4]'
 *
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * 
 * 示例：
 * 
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode newNode = null;
        ListNode indexNode = null;
        if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }else {
            //确定新链表的第一个节点
            if(l1.val > l2.val){
                indexNode = new ListNode(l2.val);
                l2 = l2.next;
            }else{
                indexNode = new ListNode(l1.val);
                l1 = l1.next;    
            }
            //newNode表示新链表的第一个节点
            newNode = indexNode;
            while(l1 != null && l2 != null){
                if(l1.val > l2.val){
                    indexNode.next = new ListNode(l2.val);
                    l2 = l2.next;
                }else{
                    indexNode.next = new ListNode(l1.val);
                    l1 = l1.next;    
                }
                indexNode = indexNode.next;
            }
            //当某一个链表遍历完时，则将另一个链表剩余部分连接到新链表的后面
            if(l1 == null){
                indexNode.next = l2;
            }else if(l2 == null){
                indexNode.next = l1;
            }
            return newNode;
        }
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode newHead = null;
        if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }else {
            if(l1.val < l2.val){
                newHead = l1;
                newHead.next = mergeTwoLists2(l1.next, l2);
            }else {
                newHead = l2;
                newHead.next = mergeTwoLists2(l1, l2.next);
            }
            return newHead;
        }
    }
}
// @lc code=end

