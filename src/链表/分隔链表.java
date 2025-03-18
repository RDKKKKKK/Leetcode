package 链表;

public class 分隔链表 {
    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode();
        ListNode largeHead = new ListNode();
        ListNode smallTail = smallHead;
        ListNode largeTail = largeHead;

        while(head != null){
            if (head.val < x) {
                smallTail.next = head;
                smallTail = smallTail.next;
            }
            else {
                largeTail.next = head;
                largeTail = largeTail.next;
            }
            head = head.next;
        }

        largeTail.next = null;

        smallTail.next = largeHead.next;

        return smallHead.next;
    }
}
