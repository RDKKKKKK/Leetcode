package 回溯;

import java.util.ArrayList;
import java.util.List;

public class 组合总和 {

    /**
     *
     * 注意回溯的理解：每次试探完都剪枝，满足则添加，不满足则不操作
     *
     * public List<List<Integer>> combinationSum(int[] candidates, int target) {
     *     List<List<Integer>> res = new ArrayList<>();
     *     ArrayList<Integer> cur = new ArrayList<>();
     *     backtrack(candidates, 0, target, res, cur);
     *     return res;
     * }
     *
     * public void backtrack(int[] candidates, int start, int target, List<List<Integer>> res, List<Integer> cur) {
     *     if (target == 0) {
     *         res.add(new ArrayList<>(cur));
     *         return;
     *     }
     *     for (int i = start; i < candidates.length; i++) {
     *         if (candidates[i] > target) continue;
     *         cur.add(candidates[i]);
     *         backtrack(candidates, i, target - candidates[i], res, cur);
     *         cur.remove(cur.size() - 1); // 回溯
     *     }
     * }
     */



    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<Integer> cur = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        return backtrack(candidates, 0, target, res, cur);

    }


    public List<List<Integer>> backtrack(int[] candidates, int sum, int target, List<List<Integer>> res, List<Integer> cur){
        for (int i = 0; i < candidates.length; i++) {
            if (sum + candidates[i] == target){
                cur.add(candidates[i]);
                res.add(cur);
            }
            else {
                cur.add(candidates[i]);
                backtrack(candidates,sum+candidates[i], target, res, cur);
                cur.remove(cur.size()-1);
            }
        }
        return res;
    }
}
