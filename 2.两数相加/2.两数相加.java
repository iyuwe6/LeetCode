class Solution {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode cursor, root = new ListNode(0);
        cursor = root;
        while(l1 != null || l2 != null || carry != 0){
            if(l1 != null){
                carry += l1.val;
                l1 = l1.next;
            }

            if(l2 != null){
                carry += l2.val;
                l2 = l2.next;
            }

            cursor.next = new ListNode(carry%10);
            carry /= 10;
            cursor = cursor.next;
        }
        return root.next;
    }
}