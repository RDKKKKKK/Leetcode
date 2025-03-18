package 二分查找;

public class 寻找旋转数组中的最小值 {


    /**
     * 本题与中间值来就行比较：
     * public int findMin(int[] nums) {
     *     int left = 0, right = nums.length - 1;
     *
     *     while (left < right) {
     *         int mid = left + (right - left) / 2;
     *
     *         if (nums[mid] > nums[right]) {
     *             // Min must be in the right part, excluding mid
     *             left = mid + 1;
     *         } else {
     *             // Min is at mid or in the left part, include mid
     *             right = mid;
     *         }
     *     }
     *
     *     // When left == right, it must be the smallest
     *     return nums[left];
     * }
     *
     *
     * 使用第一个值来进行比较的题型：查找旋转排序数组中的目标值
     * 第一个值可以辅助判断在哪个子有序数组中
     *
     * public int search(int[] nums, int target) {
     *     int left = 0, right = nums.length - 1;
     *     while (left <= right) {
     *         int mid = left + (right - left) / 2;
     *
     *         if (nums[mid] == target) {
     *             return mid;
     *         }
     *
     *         // Use nums[0] to distinguish the segments
     *         if (nums[0] <= nums[mid]) {
     *             if (nums[0] <= target && target < nums[mid]) {
     *                 right = mid - 1;
     *             } else {
     *                 left = mid + 1;
     *             }
     *         } else {
     *             if (nums[mid] < target && target <= nums[nums.length - 1]) {
     *                 left = mid + 1;
     *             } else {
     *                 right = mid - 1;
     *             }
     *         }
     *     }
     *     return -1;
     * }
     *
     */



    public int findMin(int[] nums) {
        int target = nums[0];
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        int min = Math.min(nums[right], nums[(right + 1) % nums.length]);
        return min;
    }
}
