package 链表;

import java.util.HashMap;

public class 随机链表的复制 {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        HashMap<Node, Node> map = new HashMap<>();
        Node newHead = new Node(head.val);
        map.put(head, newHead);
        Node pre = newHead;
        Node oldHead = head.next;

        while (oldHead != null) {
            Node node = new Node(oldHead.val);
            pre.next = node;
            pre = node;
            map.put(oldHead, node);
            oldHead = oldHead.next;
        }

        oldHead = head;
        pre = newHead;

        while (oldHead != null) {
            if (oldHead.random != null) { //注意空值检查，null也是有效的键，有可能返回意外值
                pre.random = map.get(oldHead.random);
            } else {
                pre.random = null;
            }
            oldHead = oldHead.next;
            pre = pre.next;
        }

        return newHead;
    }
}
