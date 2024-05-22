package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 合并区间 {

    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 1; i < intervals.length; i++) {
            int a1 = intervals[i-1][0];
            int b1 = intervals[i-1][1];
            int a2 = intervals[i][0];
            int b2 = intervals[i][1];

            if (Math.max(a1, a2) <= Math.min(b1, b2) ){
                intervals[i][0] = Math.min(a1, a2);
                intervals[i][1] = Math.max(b1, b2);
            }
            else
                res.add(intervals[i-1]);
        }

        res.add(intervals[intervals.length-1]);

        return res.toArray(new int[res.size()][]);
    }
}
