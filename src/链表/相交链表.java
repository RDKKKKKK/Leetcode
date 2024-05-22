package 链表;

/**
 * 链表长度问题时，双指针从不同位置开始走，利用其中一个碰到尾部来解决
 */

public class 相交链表 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
      int la=0, lb=0;
      ListNode ptra = headA, ptrb = headB;
      while (ptra!=null){
          la++;
          ptra=ptra.next;
      }
      while (ptrb!=null){
            lb++;
            ptrb=ptrb.next;
      }
      int diff = la - lb;
      if (diff>=0){
          for (int i = 0; i < diff; i++) {
              headA = headA.next;
          }
      }
      else {
          for (int i = 0; i < -diff; i++) {
              headB = headB.next;
          }
      }
      while (headA != null){
          if (headA==headB)
              return headA;
          headA = headA.next;
          headB = headB.next;
      }
      return null;

    }
}
