package 堆;

import java.util.*;

public class 前k个高频元素 {

    public int[] topKFrequent(int[] nums, int k){
        Map<Integer, Integer> occurrences = new HashMap<>();

        for (int num : nums)
            occurrences.put(num, occurrences.getOrDefault(num, 0)+1);

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1]; // compare value rather than key (occurrence rather than itself)
            }
        });

        for (Map.Entry<Integer,Integer> entry : occurrences.entrySet()){
            int[] cur = new int[]{entry.getKey(), entry.getValue()};

            if (queue.size() < k)
                queue.offer(cur);
            else if (queue.peek()[1] < entry.getValue()){
                queue.poll();
                queue.offer(cur);
            }
        }

        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            ret[i] = queue.poll()[0];
        }

        return ret;
        }

    /* 太复杂，有简略的表达语法
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            if (map.containsKey(num)){
                int no = map.get(num);
                map.put(num, no+1);
            }
            else
                map.put(num, 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            if (heap.size() < k)
                heap.add(entry.getValue());
            else {
                if (map.get(heap.peek()) < entry.getValue()){
                    heap.poll();
                    heap.add(entry.getValue());
                }
            }
        }

        int[] res = new int[k];
        int i=0;
        while (heap.size() != 0){
             res[i++] = heap.poll();
        }

        return res;
    }*/
}
