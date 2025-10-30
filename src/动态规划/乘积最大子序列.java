package 动态规划;

public class 乘积最大子序列 {
    public int maxProduct(int[] nums) {
        int imax = nums[0];
        int imin = nums[0];
        int max = nums[0];

        for(int i=1;i<nums.length;i++){
            if(nums[i] < 0){
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }

            imax = Math.max(nums[i], imax*nums[i]);
            imin = Math.min(nums[i], imin*nums[i]);

            max = Math.max(max, imax);
        }

        return max;
    }

    public int maxProductWrong(int[] nums) {
        int imax = nums[0];
        int imin = 0;
        int max = Integer.MIN_VALUE;

        for(int i=1;i<nums.length;i++){
            if(nums[i] < 0){
                imax = Math.max(nums[i], imin*nums[i]);
                imin = Math.min(nums[i], imax*nums[i]);  //imin在用imax，但是imax已经被update了
            }
            else{
                imax = Math.max(nums[i], imax*nums[i]);
                imin = Math.min(nums[i], imin*nums[i]); //imax update imax，不影响
            }
            max = Math.max(max, imax);
        }

        return max;
    }
}
