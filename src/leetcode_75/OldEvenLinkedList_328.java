package leetcode_75;

import 链表.ListNode;

public class OldEvenLinkedList_328 {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode newHead = new ListNode(head.val), newCur = newHead, even = head.next, odd = head.next.next;

        while(odd != null){
            newCur.next = new ListNode(odd.val);
            newCur = newCur.next;
            if(odd.next == null) break;
            odd = odd.next.next;
        }

        while(even != null){
            newCur.next = new ListNode(even.val);
            newCur = newCur.next;
            if(even.next == null) break;
            even = even.next.next;
        }

        return newHead;

    }
}
