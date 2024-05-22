package 回溯;

import java.util.ArrayList;
import java.util.List;

public class 子集 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(res, new ArrayList<>(), -1, nums);
        return res;
    }

    public void backtracking(List<List<Integer>> res, List<Integer> path, int prv, int[] nums){
        res.add(new ArrayList<>(path));
        for (int i = prv+1; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(res, path, i, nums);
            path.remove(path.size()-1);
        }
    }
}
