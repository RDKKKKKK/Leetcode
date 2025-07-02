package 回溯;

import java.util.ArrayList;
import java.util.List;

public class 分割回文串 {
    /**
     * 回溯思想：
     * 假设 s[i,j] 为回文串，则i=j+1,并j++直至找到下一个 s[i,j] 为回文串
     * 找到则添加，到头则将当前 s[i,j] 去除
     *
     * 判断回文串：
     *  1. 双指针for循环
     *      bool isPalindrome(const string& s, int start, int end) {
     *      for (int i = start, j = end; i < j; i++, j--) {
     *          if (s[i] != s[j])
     *              return false;
     *      }
     *          return true;
     *      }
     *
     *  2. 动态规划
     * 每次双指针判断回文串有重复操作，使用二维动态规划数组dp[i][j]来记录s[i,j]是否回文串
     * 状态转移方程：
     *       dp[i][j] = (s.charAt(i) == s.charAt(j)) && (j - i <= 2 || dp[i + 1][j - 1]);
     *       注意i和j的遍历顺序，以免出现未知状态的转移
     *
     * 注意：
     * 添加答案要新建，否则为同一个值 res.add(new ArrayList<>(cur));
     *
     */
    boolean[][] dp;
    List<List<String>> res = new ArrayList<>();
    List<String> cur = new ArrayList<>();
    int n;


    public List<List<String>> partition(String s){
        n = s.length();
        dp = new boolean[n][n];
        for (int j=0; j<n; j++){
            for (int i=j; i>0; i--){
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1]);
            }
        }

        backtrack(s, 0);
        return res;
    }

    public void backtrack(String s, int i) {
        if (i == n) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int j = i; j < n; j++) {
            if (dp[i][j]) {
                cur.add(s.substring(i, j + 1));
                backtrack(s, j + 1);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
