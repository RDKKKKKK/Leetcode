package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 子集2 {

    /**
     * 需要去重：
     * 		在同一递归层中，避免重复选择相同的数字
     * 		在不同递归层中，允许重新选择相同的数字
     * 	 used数组的核心作用是: 跟踪当前递归路径中某个元素是否被选择过
     * 	                 如果 nums[i-1] 没有被使用（!used[i-1]）说明当前递归层之前已经处理过 nums[i-1]
     * 	                 因此当前层不应该再次选择 nums[i]，以避免重复。
     */


    List<List<Integer>> res = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();
    boolean[] used = new boolean[10];

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        res.add(new ArrayList<>(cur));
        backtrack(nums, 0);
        return res;

    }

    public void backtrack(int[] nums, int index){

        for(int i=index;i<nums.length;i++){
            if ( i>0 && nums[i] == nums[i-1] && !used[i-1]){
                continue;
            }
            cur.add(nums[i]);
            res.add(new ArrayList<>(cur));
            used[i] = true;
            backtrack(nums, i+1);
            cur.remove(cur.size()-1);
            used[i] = false;

        }


    }}
