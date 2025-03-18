package leetcode_75;

public class ProductOfArrayExceptSelf_238 {
    /**
     * 更简短解法：两次循环计算每个数的左右边乘积
     * @param nums
     * @return
     */



    public int[] productExceptSelf(int[] nums) {
        boolean hasZero = (nums[0] == 0);
        boolean hasMultiZero = false;
        int product;
        if(hasZero) product = 1;
        else product = nums[0];
        int[] res = new int[nums.length];

        for (int i=1;i< nums.length;i++){
            if (nums[i] == 0){
                if (hasZero){
                    hasMultiZero = true;
                    continue;
                }
                hasZero = true;
                continue;
            }
            product*=nums[i];
        }
        if (hasMultiZero) return res;

        if (hasZero){
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0)
                    res[i] = 0;
                else
                    res[i] = product;
            }
        }
        else {
            for (int i = 0; i < nums.length; i++) {
                res[i] = product/nums[i];
            }
        }

        return res;
    }
}
