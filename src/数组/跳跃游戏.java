package 数组;

public class 跳跃游戏 {
    public boolean canJump(int[] nums) {
        boolean jump = true;
        int dest = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (jump && nums[i] < 1) {
                jump = false;
                dest = i + 1;
            }
            else if (!jump && dest - i <= nums[i]){
                jump = true;
            }
        }
        return jump;
    }
}
