package 矩阵;

import java.util.ArrayList;
import java.util.List;

public class 螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int next = 0; // 0: right, 1: down, 2: left, 3: up
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = n - 1, up = 0, down = m - 1;
        List<Integer> res = new ArrayList<>();

        while (res.size() < m * n) {
            if (next == 0) { // Move right
                for (int j = left; j <= right; j++) res.add(matrix[up][j]);
                up++;
            } else if (next == 1) { // Move down
                for (int i = up; i <= down; i++) res.add(matrix[i][right]);
                right--;
            } else if (next == 2) { // Move left
                for (int j = right; j >= left; j--) res.add(matrix[down][j]);
                down--;
            } else if (next == 3) { // Move up
                for (int i = down; i >= up; i--) res.add(matrix[i][left]);
                left++;
            }
            next = (next + 1) % 4;
        }

        return res;
    }

}
