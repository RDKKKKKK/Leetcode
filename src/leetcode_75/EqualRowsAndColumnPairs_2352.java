package leetcode_75;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EqualRowsAndColumnPairs_2352 {
    /**
     * 可以用哈希表判断List（行/列）是否存在
     * @param grid
     * @return
     */

    public int equalPairs1(int[][] grid) {
        int n = grid.length;
        Map<List<Integer>, Integer> cnt = new HashMap<List<Integer>, Integer>();
        for (int[] row : grid) {
            List<Integer> arr = new ArrayList<Integer>();
            for (int num : row) {
                arr.add(num);
            }
            cnt.put(arr, cnt.getOrDefault(arr, 0) + 1);
        }

        int res = 0;
        for (int j = 0; j < n; j++) {
            List<Integer> arr = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                arr.add(grid[i][j]);
            }
            if (cnt.containsKey(arr)) {
                res += cnt.get(arr);
            }
        }
        return res;
    }


    public int equalPairs(int[][] grid) {
        int count = 0;
        int n = grid.length;

        for (int i = 0; i < n; i++) {
            int cur = grid[0][i];
            for (int j = 0; j < n; j++) {
                int find = grid[j][0];
                if (find == cur){
                    boolean matched = true;
                    for (int k = 1; k < n; k++) {
                        if(grid[k][i] != grid[j][k]) {
                            matched = false;
                            break;
                        }
                    }
                    if (matched) count++;
                }
            }
        }

        return count;
    }
}
