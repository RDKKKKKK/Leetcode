package 数组;

public class 递增的三元子序列 {
    /**
     * 不必局限于找出i,j,k 只需判断出存在i,j,k
     * 最后得到的first/second可能不是按顺序 但在之前一定存在满足条件的
     * 因此尽力使i,j小
     * new_first < old_first < second
     */
    public boolean increasingTriplet(int[] nums) {
        int first = nums[0], second = Integer.MAX_VALUE;
        for(int i=1;i<nums.length;i++){
            if (nums[i] > second){
                return true;
            }
            else if (nums[i] > first){
                second = nums[i];
            }
            else if (nums[i] < first){
                first = nums[i];
            }
        }
        return false;
    }
}
