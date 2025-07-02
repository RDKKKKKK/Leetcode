package 贪心算法;

public class 最大子数组和 {
    public int maxSubArray(int[] nums) {
        int start=0, end=0, sum=0, max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(sum < 0)
                sum = nums[i];
            else
                sum+=nums[i];

            if(sum>max)
                max = sum;
        }

        return max;
    }
}
