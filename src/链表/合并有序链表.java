package 链表;

public class 合并有序链表 {

    /**    可以用递归
     *     public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
     *         if (l1 == null) {
     *             return l2;
     *         } else if (l2 == null) {
     *             return l1;
     *         } else if (l1.val < l2.val) {
     *             l1.next = mergeTwoLists(l1.next, l2);
     *             return l1;
     *         } else {
     *             l2.next = mergeTwoLists(l1, l2.next);
     *             return l2;
     *         }
     *     }
     *
     */

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        ListNode res = new ListNode();
        ListNode cur3 = res;

        while (cur1 != null && cur2 != null){
            if (cur1.val <= cur2.val){
                cur3.val = cur1.val;
                cur1 = cur1.next;
            }
            else{
                cur3.val = cur2.val;
                cur2 = cur2.next;
            }
            cur3.next = new ListNode();
            cur3 = cur3.next;
        }

        //不用再循环添加，直接将当前遍历到的点接到res里，注意next和直接赋值的区别
        /*
        if (cur1 != null)
            cur3 = cur1;
        else
            cur3 = cur2;*/
        if (cur1 != null){
            cur3.val = cur1.val;
            cur3.next = cur1.next;
        }

        if (cur2 != null){
            cur3.val = cur2.val;
            cur3.next = cur2.next;
        }

        if (cur1 == null){
            while (cur2.next != null){
                cur3.val = cur2.val;
                cur2 = cur2.next;
                cur3.next = new ListNode();
                cur3 = cur3.next;
            }
            cur3.val = cur2.val;
        }
        else {
            while (cur1.next != null){
                cur3.val = cur1.val;
                cur1 = cur1.next;
                cur3.next = new ListNode();
                cur3 = cur3.next;
            }
            cur3.val = cur1.val;
        }

        return res;
    }
}
