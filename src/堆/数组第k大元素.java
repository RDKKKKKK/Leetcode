package 堆;

public class 数组第k大元素 {



    /* 堆排序：时间复杂度：建堆O(n) 排序O(logn)
        关于建堆的复杂度：
            如果你计算每层的工作量，你会发现对于大多数节点，它们的高度（相对于树底）实际上是相对较低的
            因此，虽然对于单个节点而言，maxHeapify的时间复杂度是O(logn)，
            但是对整个堆来说，因为高度较小的节点占多数，所以整体的平均复杂度降低了
    */
    public int findKthLargest_HEAP(int[] nums, int k) {
        buildMaxHeap(nums, nums.length);
        int size = nums.length;
        for (int i = 0; i < k-1; i++) { //删除k-1个
            swap(nums, 0, size-1);
            size--; //抛弃最后一个刚swap的节点
            maxHeapify(0, nums, size);
        }
        return nums[0];
    }

    public void buildMaxHeap(int[] nums, int heapSize){
        for (int i = heapSize / 2 - 1; i >= 0; i--) {
            maxHeapify(i, nums, nums.length);
        }
    }

    public void maxHeapify(int root, int[] nums, int size){
        int left = root*2 + 1;
        int right = root*2 + 2;
        int largest = root;

        if (left < size && nums[left] > nums[largest]) largest = left;
        if (right < size && nums[right] > nums[largest]) largest = right;

        if (largest != root){
            swap(nums, root, largest);
            maxHeapify(largest, nums, size);
        }
    }

    private void swap(int[] nums, int root, int largest) {
        int temp = nums[root];
        nums[root] = nums[largest];
        nums[largest] = temp;
    }
}
