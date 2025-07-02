package leetcode_75;

import 链表.ListNode;

public class MaxTwinSumOfLinkedList {
    public int pairSum(ListNode head) {
        ListNode left = head, right = head, fast = head;
        int n = 0;
        while (fast != null){
            fast = fast.next.next;
            right = right.next;
            n++;
        }
        System.out.println(n);

        ListNode pre = right;
        right = right.next;
        while(right != null){
            ListNode tmp = right.next;
            right.next = pre;
            pre = right;
            right = tmp;
        }

        right = pre;
        System.out.println(right.val);
        int max = left.val + right.val;

        for (int i=1;i<n;i++){
            left = left.next;
            right = right.next;
            max= Math.max(max, left.val+right.val);
        }

        return max;

    }
}
