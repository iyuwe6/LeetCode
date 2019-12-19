import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个排序链表
 *
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/description/
 *
 * algorithms
 * Hard (47.38%)
 * Likes:    413
 * Dislikes: 0
 * Total Accepted:    60.5K
 * Total Submissions: 125.8K
 * Testcase Example:  '[[1,4,5],[1,3,4],[2,6]]'
 *
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * 
 * 示例:
 * 
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    //贪心算法，优先队列
    public ListNode mergeKLists1(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) {
            return null;
        }
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(len, Comparator.comparingInt(a -> a.val));
        ListNode dummyNode = new ListNode(-1);
        ListNode curNode = dummyNode;
        for (ListNode list : lists) {
            if (list != null) {
                // 这一步很关键，不能也没有必要将空对象添加到优先队列中
                priorityQueue.add(list);
            }
        }
        while (!priorityQueue.isEmpty()) {
            // 优先队列非空才能出队
            ListNode node = priorityQueue.poll();
            // 当前节点的 next 指针指向出队元素
            curNode.next = node;
            // 当前指针向前移动一个元素，指向了刚刚出队的那个元素
            curNode = curNode.next;
            //出队的链表是否还有节点，若有，则加入优先队列
            if (curNode.next != null) {
                // 只有非空节点才能加入到优先队列中
                priorityQueue.add(curNode.next);
            }
        }
        return dummyNode.next;
    }

    //分治法
    public ListNode mergeKLists2(ListNode[] lists) {
        int len = lists.length;
        if(len == 0){
            return null;
        }
        return mergeKLists2(lists, 0, len-1);
    }

    public ListNode mergeKLists2(ListNode[] lists, int i, int j){
        if(i == j){
            return lists[i];
        }
        int mid = (j-i)/2 + i;
        ListNode l1 = mergeKLists2(lists, i, mid);
        ListNode l2 = mergeKLists2(lists, mid+1, j);
        return mergeTwoSortedListNode(l1, l2);
    }

    private ListNode mergeTwoSortedListNode(ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1.val < l2.val){
            l1.next = mergeTwoSortedListNode(l1.next, l2);
            return l1;
        }
        l2.next = mergeTwoSortedListNode(l1, l2.next);
        return l2;
    }
}
// @lc code=end

