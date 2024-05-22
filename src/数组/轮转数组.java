package 数组;

public class 轮转数组 {
    public void rotate(int[] nums, int k) {
        int move = k % nums.length;
        int temp = nums[0], start = -1, count = 0, cur = nums[0], next = move;
        while (count!=nums.length){
            if (start != cur){
                temp = nums[next];
                nums[next] = temp;
                cur = next;
                next = (next+move)%nums.length;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i != start){
                temp = nums[i+move];
                nums[i+move] = nums[i];
        }
        }
    }
}
