package 数组;

public class 删除有序数组的重复项 {


    /**
     * 使用双指针，快指针读取新值，慢指针指向要被覆盖的值
     * 对于两个重复才替换的情况，比较时改用 nums[slow - 2] != nums[fast]即可
     *    public int removeDuplicates(int[] nums) {
     *         int n = nums.length;
     *         if (n <= 2) {
     *             return n;
     *         }
     *         int slow = 2, fast = 2;
     *         while (fast < n) {
     *             if (nums[slow - 2] != nums[fast]) {
     *                 nums[slow] = nums[fast];
     *                 ++slow;
     *             }
     *             ++fast;
     *         }
     *         return slow;
     *     }
     *
     */

    public int removeDuplicates(int[] nums) {
        boolean twice = false;
        int slow=1;

        for(int i=1;i<nums.length;i++){
            if(nums[i] == nums[i-1]){
                if(twice) continue;
                else {
                    nums[slow] = nums[i];
                    twice = true;
                    slow++;
                }
            }
            else{
                nums[slow] = nums[i];
                if(twice) twice = false;
                slow++;
            }

        }

        return slow;
    }
}
