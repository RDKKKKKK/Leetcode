package 回溯;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 全排列 {
    public List<List<Integer>> permute(int[] nums){
        Stack<Integer> path = new Stack<>();
        List<List<Integer>> res = new ArrayList<>();
        backtracking(nums.length, path, nums, res);
        return res;
    }

    public void backtracking(int len, Stack<Integer> path, int[] nums, List<List<Integer>> res){
        if (path.size() == len){
            res.add(path); // new ArrayList<>(path) 原先代码path为地址（函数传参）最终会为空
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!path.contains(nums[i])){
                path.push(nums[i]);
                backtracking(len, path, nums, res);
                path.pop();
            }
        }
    }
}
