package 数组;

public class 跳跃游戏2 {
    public int jump(int[] nums) {
        int index = nums.length-1;
        int dest = index, step = 0, leftmost = 0, count = 0;
        while (index != 0){
            step = 0;
            for (int i = index-1; i >= 0; i--) {
                step++;
                if(nums[i] >= step)
                    leftmost = i;
            }
            index = leftmost;
            count++;
        }
        return count;
    }
}
