package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 用map来避免重复
 */

public class 非递减子序列 {

    /**
     *     List<Integer> cur = new ArrayList<>();
     *     List<List<Integer>> res = new ArrayList<>();
     *
     *     public List<List<Integer>> findSubsequences(int[] nums) {
     *         backtracking(nums, 0);
     *         return res;
     *     }
     *
     *     public void backtracking(int[] nums, int index) {
     *         if (cur.size() > 1) {
     *             res.add(new ArrayList<>(cur)); // 添加当前非递减子序列
     *         }
     *
     *         Set<Integer> used = new HashSet<>(); // 本层已使用的数字
     *         for (int i = index; i < nums.length; i++) {
     *             // 如果当前数字已经被使用，跳过，避免同层重复
     *             if (used.contains(nums[i])) continue;
     *             // 如果当前数字小于前一个数字，跳过，保持非递减性
     *             if (!cur.isEmpty() && nums[i] < cur.get(cur.size() - 1)) continue;
     *
     *             used.add(nums[i]); // 标记当前数字已使用
     *             cur.add(nums[i]);  // 添加当前数字到当前序列
     *             backtracking(nums, i + 1); // 递归处理后续数字
     *             cur.remove(cur.size() - 1); // 回溯，移除最后一个数字
     *         }
     *     }
     */

    List<Integer> cur = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, 0);
        return res;
    }

    public void backtracking(int[] nums, int index){
        for (int i = index; i < nums.length; i++) {

            if (i > 0 && nums[i] == nums[i-1] && cur.size()>0 && cur.get(cur.size()-1) != nums[i]) {
                System.out.println(cur);
                continue;
            }

            if (cur.isEmpty()) cur.add(nums[i]);
            else if (nums[i] >= cur.get(cur.size()-1)) cur.add(nums[i]);
            else continue;

            if (cur.size()>1) res.add(new ArrayList<>(cur));
            backtracking(nums, i+1);
            cur.remove(cur.size()-1);
        }
    }
}
