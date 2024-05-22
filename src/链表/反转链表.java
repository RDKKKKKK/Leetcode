package 链表;

/**
 * 第一个节点的next指针在反转后应指向null
 */

public class 反转链表 {
    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode cur = head;
            ListNode prv = null;
            while (cur.next != null) {
                ListNode tmp = new ListNode();
                tmp.next = prv;
                prv = cur;
                cur = cur.next;
                prv.next = tmp.next;
            }
            cur.next = prv;
            return cur;
        }
    }
}
