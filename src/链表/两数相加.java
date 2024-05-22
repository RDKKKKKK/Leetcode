package 链表;

public class 两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode cur = res;
        int plus = 0;
        while (l1 != null || l2 != null){
            if(l1 != null && l2 != null ){
                res.val = (l1.val + l2.val + plus)%10;
                if (l1.val + l2.val >= 10)
                    plus=1;
                else
                    plus=0;
                l1 = l1.next;
                l2 = l2.next;
            }
            else if (l1 == null) {
                res.val = l2.val;
                if(l2.next != null) cur.next = new ListNode(0);
            }
            else {
                res.val = l1.val;
                l1 = l1.next;
            }

            if (l1.next != null  ){
                cur.next = new ListNode(0);
            }

            cur = cur.next;

        }
        return res;
    }
}
