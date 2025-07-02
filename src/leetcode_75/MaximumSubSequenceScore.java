package leetcode_75;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 比较的相关语法：
 * Integer.compare(a, b) 返回 <0 表示 a<b
 */

public class MaximumSubSequenceScore {
    /**
     * 	对下标按照 nums2 的值降序排序：
     * 	•	这样可以确保我们优先选取 nums2 中值较大的元素，从而在后续计算中，子序列的最小值尽可能大。
     * 	维护一个长度为 k 的最小堆，动态维护 nums1 的和：
     * 	•	我们使用一个最小堆来存储当前选出的 k 个 nums1 的元素，并动态维护它们的和。
     * 	•	每次遇到一个新的元素时，如果它比最小堆中的最小值大，就将最小值替换掉，从而增加 nums1 的和。
     * 	每次更新分数：
     * 	•	每次选满 k 个元素后，计算当前的分数，并与已知的最大分数进行比较，更新最大分数。
     */
    public long maxScore1(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        Integer[] indices = new Integer[n];
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        long res=0, cur=0;

        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, (a,b) -> Integer.compare(nums2[b], nums2[a])); // 只能传Integer不能int

        for(int i=0;i<k;i++){
            int index = indices[i];
            cur += nums1[index];
            heap.add(nums1[index]);
        }

        res = cur*nums2[indices[k-1]];

        for (int i=k;i<n;i++){
            int index = indices[i];
            if (nums1[index] > heap.peek()){
                cur += nums1[index] - heap.poll();
                heap.add(nums1[index]);
                res = Math.max(res, cur*nums2[index]);
            }

        }

        return res;
    }



        public long maxScore(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length;
        int res=0, res1=0, res2=0;

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int[] indices = new int[n1];

        for (int i=0;i<nums1.length;i++){
            indices[i] = i;
        }

        for(int i=0;i<k;i++){
            res1 += nums1[i];
            heap.add(nums2[indices[i]]);
        }

        res = res1 + heap.peek();

        for(int i=k;i<n1;i++){
            res1 += nums1[i];
            res1 -= nums1[i-k];
        }

        return (long) res;
    }

    public int findMinNums2(int[] nums2, int start, int end){
        int[] sorted = new int[end-start];
        int k = 0;
        for (int i=start; i<end; i++){
            sorted[k++] = nums2[i];
        }

        Arrays.sort(sorted);
        return sorted[0];
    }
}
