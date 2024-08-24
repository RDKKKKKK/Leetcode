package 数组;

public class 轮转数组 {
    /**
     * 2024/8/12 使用翻转，依靠一个翻转函数
     * 先翻转整个数组，再分别翻转前k个 和 后n-k个
     * 来达到轮转数组的效果
     */

    public void rotate(int[] nums, int k){
        k = k % nums.length;
        if(k == 0 || k == nums.length) return;

        flip(nums, 0, nums.length-1);
        flip(nums, 0, k-1);
        flip(nums, k, nums.length-1);
    }

    public void flip(int[] nums, int start, int end){
        for (int i = 0; i <= (end - start)/2 ; i++) {
            int temp = nums[start+i];
            nums[start+i] = nums[end-i];
            nums[end-i] = temp;
        }
    }

    /*
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
    }*/
}
