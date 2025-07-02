package 滑动窗口;

public class 最大连续1的个数 {

        public int longestOnes(int[] nums, int k) {
            int count = 0;
            int index = 0;
            int max = 0;
            while(count != k && index<nums.length){
                if(nums[index++] == 0) count++;
                max++;
            }
            int left = 0;
            int cur=0;
            for(int i=index;i<nums.length;i++){
                if(nums[i] == 0) {
                    while(nums[left] != 0 && left < i){
                        left++;
                    }
                    left++;
                }
                cur = i-left+1;
                if(cur > max) max = cur;
            }

            return max;
        }
}
