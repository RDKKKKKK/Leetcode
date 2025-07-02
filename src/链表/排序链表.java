package 链表;

import java.util.ArrayList;
import java.util.Arrays;

public class 排序链表 {
    public ListNode sortList(ListNode head) {
        int size = 0;
        ListNode copy = head;
        while (copy != null){
            size++;
            copy = copy.next;
        }
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = head.val;
            head = head.next;
        }

        build(arr, arr.length);
        ListNode res = new ListNode();
        ListNode resHead = res;

        while (size > 0) {
            res.next = new ListNode(arr[0]);
            res = res.next;
            swap(arr, 0, --size);
            heapify(0, arr, size);
        }

        return resHead.next;

    }

    public void heapify(int root, int[] nums, int size) {
        int left = root * 2 + 1;
        int right = root * 2 + 2;
        int smallest = root;

        //记录当前三个节点中的smallest值
        if (left < size && nums[left] < nums[smallest]) smallest = left;
        if (right < size && nums[right] < nums[smallest]) smallest = right;

        //若最大的不在root则换上去
        if (smallest != root) {
            swap(nums, root, smallest);
            heapify(smallest, nums, size);
        }
    }

    public void build(int[] arr, int size){
        for (int i = size/2-1; i >= 0; i--) {
            heapify(i, arr, size);
        }
    }

    private void swap(int[] nums, int root, int smallest) {
        int temp = nums[root];
        nums[root] = nums[smallest];
        nums[smallest] = temp;
    }
}
