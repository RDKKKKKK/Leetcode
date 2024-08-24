package 数组;

public class 除自身以外数组的乘积 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] front = new int[n];
        int[] back = new int[n];
        int[] res = new int[n];

        int fr_count = 1;
        int bc_count = 1;

        for (int i = 0; i < n; i++) {
            front[i] = fr_count*nums[i];
            fr_count = front[i];
        }

        for (int i = n-1; i >= 0 ; i--) {
            back[i] = bc_count*nums[i];
            bc_count = back[i];
        }

        for (int i = 1; i < n-1; i++) {
            res[i] = front[i-1]*back[i+1];
        }
        res[0] = back[1];
        res[n-1] = front[n-2];

        return res;
    }
}
