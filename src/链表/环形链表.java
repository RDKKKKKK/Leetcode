package 链表;

public class 环形链表 {
    public boolean hasCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;

        while (fast!=null && fast.next != null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow==fast)
                return true;
        }

        return false;
    }
}
