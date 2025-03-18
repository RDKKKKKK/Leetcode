package leetcode_75;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII_216 {
    boolean[] used = new boolean[10];
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> cur = new ArrayList<>();
        backtrack(n, cur, 1, k, 0);
        return res;
    }

    public void backtrack(int need, List<Integer> cur, int i, int k, int num){
        if (need == 0 && num == k){
            res.add(new ArrayList<>(cur));
            return;
        }

        if (need < 0 || num == k)
            return;

        for (int j = i; j <= 9; j++) {
            if (used[j]) continue;
            cur.add(j);
            used[j] = true;
            backtrack(need - j, cur, j, k, num+1);
            used[j] = false;
            cur.remove(cur.size()-1);
        }
    }
}
