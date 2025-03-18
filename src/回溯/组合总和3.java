package 回溯;

import java.util.ArrayList;
import java.util.List;

public class 组合总和3 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();

    // the k number combination with sum n
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(k, n, 1, 0);
        return res;
    }

    public void backtrack(int k, int n, int index, int sum){
        if (sum > n || cur.size() > k) return;
        if (cur.size() == k && sum == n) {
            res.add(new ArrayList<>((cur)));
            return;
        }
        for (int i=index;i<=9;i++){
            cur.add(i);
            sum+=i;
            backtrack(k, n, i+1, sum);
            cur.remove(cur.size()-1);
            sum-=i;
        }
    }
}
