package 贪心算法;
import java.util.Arrays;


public class 不重叠区间 {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;

        // 按照区间的结束时间升序排序
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int count = 0; // 记录需要移除的区间数量
        int end = intervals[0][1]; // 第一个区间的结束时间

        // 从第二个区间开始遍历
        for (int i = 1; i < intervals.length; i++) {
            // 如果当前区间的起点小于前一个选择的区间的结束点，说明发生了重叠
            if (intervals[i][0] < end) {
                count++; // 需要移除当前区间
            } else {
                // 如果不重叠，更新结束时间为当前区间的结束时间
                end = intervals[i][1];
            }
        }

        return count;
    }

    /**
     *    public int eraseOverlapIntervals(int[][] intervals) {
     *         int[] res = new int[100000];
     *         int max = Integer.MIN_VALUE;
     *         for(int[] interval : intervals){
     *             for(int i= interval[0]; i<=interval[1]; i++){
     *                 res[i]+=1;
     *                 if(i > max) max = i;
     *             }
     *         }
     *         boolean flag = false;
     *         int count = 0;
     *         int base = 1;
     *
     *         for(int i =0;i<=max;i++){
     *             System.out.println(res[i]+ " ");
     *             if (res[i] == 0 || res[i] == 1){
     *                 flag = false;
     *                 continue;
     *             }
     *             if (res[i] > 1 && flag == false){
     *                 count += res[i] - base;
     *                 flag = true;
     *                 base = res[i];
     *             }
     *         }
     *
     *         return count;
     *
     *     }
     *
     */
}
