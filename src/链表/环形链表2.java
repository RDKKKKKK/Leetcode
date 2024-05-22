package 链表;

/**
 * 链表问题双指针间的碰撞很关键，链表没有索引，通过统计步数比设计碰撞点可以解决数字问题
 */

public class 环形链表2 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        boolean flag = false;
        while (fast!=null && fast.next != null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow==fast) {
                flag = true;
                break;
            }
        }
        if (!flag)
            return null;
        do {
            fast = fast.next;
        }while (fast!=slow);
        while (head!=slow){
            head=head.next;
            slow=slow.next;
        }
        return head;
    }
}
