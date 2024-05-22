package 双指针;

import java.util.*;


public class 三数之和 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // 首先对数组进行排序
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 跳过重复的数字
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
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


    /*
    public List<List<Integer>> threeSum(int[] nums) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int need = -nums[i];
            int left = 0, right = nums.length-1;

            while (left != right && left>=0 && right>=0){
                if (left == i)
                    left++;
                if (right == i)
                    right--;

                if (nums[left]+nums[right] > need){
                    if (nums[left]>=nums[right])
                        left++;
                    else
                        right--;

                }
                else if (nums[left]+nums[right] < need){
                    if (nums[left]>=nums[right])
                        right--;
                    else
                        left++;
                }
                else {
                    List<Integer> list = new ArrayList<>();
                    List<Integer> listAlready = map.get(nums[i]);

                    if (map.containsKey(nums[i]) && listAlready.contains(left) && listAlready.contains(right))
                        continue;
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                    left++;
                    right--;
                    if (!map.containsKey(nums[i]) ){

                    }
            }

        }
        return res;
    }*/

