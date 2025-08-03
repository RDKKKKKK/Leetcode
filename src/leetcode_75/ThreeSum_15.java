package leetcode_75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {

    /**
     * 哈希表太复杂，使用双指针
     * 先对数组排序，在遍历数组
     * 对于每个选中的数，在其后方放指针left,数组尾房right，根据和的情况移动指针
     *
     */

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // 首先对数组进行排序
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) continue; // 整体不可能再小于0了
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 跳过重复的数字：num[i] = nums[i-1] 若此数上轮已遍历则跳过
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    //判断可省略
                    while (left < right && nums[left] == nums[left + 1]) left++; // 跳过重复的数字
                    while (left < right && nums[right] == nums[right - 1]) right--; // 跳过重复的数字
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}
