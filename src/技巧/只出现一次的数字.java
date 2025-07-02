package 技巧;

public class 只出现一次的数字 {
    /**
     * XOR
     * a^0 = a
     * a^a = a
     * a^b^c = c^a^b  交换律结合律
     */
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
