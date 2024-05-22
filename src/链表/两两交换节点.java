package 链表;

public class 两两交换节点 {

    // 迭代 + 递归实现

    public ListNode swapPairs(ListNode head) {
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode tmp = newHead;

        while (tmp.next != null && tmp.next.next != null){
            ListNode node1 = tmp.next;
            ListNode node2 = tmp.next.next;

            node1.next = node2.next;
            tmp.next = node2;
            node2.next = node1;

            tmp = node1;
        }

        return newHead.next;
    }

    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode node = head.next;
        head.next = swapPairs1(node.next);
        node.next = head;
        return node;
    }

    }
