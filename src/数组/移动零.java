package 数组;

/**
 * 双指针：为了确保原顺序，右指针判断数，左指针记录位置
 * 左边不用管原先是什么数，右指针遍历的时自然会找出所有非0且顺序不变
 */

public class 移动零 {
    public void moveZeroes(int[] nums){
        int left = 0,  flag = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                nums[left] = nums[i];
                left++;
            }
        }
        for (int i = left; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /*
    public void moveZeroes(int[] nums) {
        int count = 0, next=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0){
                while (next<nums.length-1 && nums[next] == 0){
                    next++;
                }
                nums[i] = nums[next];
                count++;
                nums[next] = -1;
                if(next<nums.length-1)
                    next++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == -1){
                while (next<nums.length-1 && nums[next] == 0){
                    next++;
                }
                nums[i] = nums[next];
                nums[next] = -1;
                if(next<nums.length-1)
                    next++;
            }
        }
        for (int i = nums.length-count; i < nums.length ; i++) {
            nums[i] = 0;
        }
    }*/
}
