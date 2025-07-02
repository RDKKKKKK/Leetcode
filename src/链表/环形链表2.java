package 链表;
/**
 * 2024.11.24
 * 结论：二倍速快指针和慢指针碰撞的地方，发出一个指针，同时从头也发出一个指针，这两个指针碰撞的地方即为入环点
 * 推导：
 *     要点1：借助时间相同，速度两倍，路程差为n圈，得出 头节点到入环点 = n圈 - 当前碰撞点 (x+y)*2=x+y+n(y+z)
 *     要点2：快指针第一次撞慢指针时，慢指针一定处于第一圈（相对速度为1）不影响解，用之后碰撞的点一样可解
 */

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
