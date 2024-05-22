package 动态规划;

import java.util.ArrayList;
import java.util.List;

public class 杨辉三角 {

    /**
     * 更省空间的解法：考虑返回值为List，不要从dp数组再复制一遍，直接操作
     * @param numRows
     * @return
     */

    public List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        if (numRows > 0) {
            List<Integer> firstRow = new ArrayList<>();
            firstRow.add(1);
            triangle.add(firstRow);
        }

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum - 1);

            row.add(1); // 第一个元素总是1

            for (int j = 1; j < rowNum; j++) {
                // 计算中间的元素，等于上一行的两个相邻元素之和
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            row.add(1); // 最后一个元素也是1
            triangle.add(row);
        }

        return triangle;
    }



    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        int[][] dp = new int[31][31];
        List<Integer> list = new ArrayList<>();

        dp[0][0] = 1;
        list.add(dp[0][0]);
        lists.add(list);


        for (int i = 1; i < numRows; i++) {
            list = new ArrayList<>();
            dp[i][0] = 1;
            list.add(dp[i][0]);
            for (int j = 1; j < i; j++) {
                dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
                list.add(dp[i][j]);
            }
            dp[i][i] = 1;
            list.add(dp[i][i]);
            lists.add(list);
        }
        return lists;
    }


    public static void main(String[] args) {
        杨辉三角 杨辉三角 = new 杨辉三角();
        杨辉三角.generate(5);
    }
}
