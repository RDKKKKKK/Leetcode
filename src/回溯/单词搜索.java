package 回溯;

import java.util.Stack;

public class 单词搜索 {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtrack(visited, board, 0, m, n, word, i, j))
                    return true;
            }
        }
        return false;
    }

    public boolean backtrack (boolean[][] visited, char[][] board, int index, int m, int n, String target,
                              int lastM, int lastN){
        if (lastM == m || lastN == n || lastM == -1 || lastN == -1)
            return false;

        if (board[lastM][lastN] == target.charAt(index) && visited[lastM][lastN] == false) {
            visited[lastM][lastN] = true;
            if (index == target.length()-1)
                return true;
        } else
            return false;

        if  (backtrack(visited, board, index + 1, m, n, target, lastM - 1, lastN) ||
                backtrack(visited, board, index + 1, m, n, target, lastM, lastN - 1) ||
                backtrack(visited, board, index + 1, m, n, target, lastM + 1, lastN) ||
                backtrack(visited, board, index + 1, m, n, target, lastM, lastN + 1))
            return true;
        else {
            visited[lastM][lastN] = false; //撤销
            return false;
        }
    }
}
