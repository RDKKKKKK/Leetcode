package 数组;

public class 递增的三元子序列 {


    /**
     *
     * 赋初始值的时候，已经满足second > first了，现在找第三个数third
     * (1) 如果third比second大，那就是找到了，直接返回true
     * (2) 如果third比second小，但是比first大，那就把second指向third，然后继续遍历找third
     * (3) 如果third比first还小，那就把first指向third，然后继续遍历找third（这样的话first会跑到second的后边，但是不要紧，因为在second的前边，老first还是满足的）
     */

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
