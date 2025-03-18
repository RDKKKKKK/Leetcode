package leetcode_75;

public class CountingBits {

    /**
     * dynamic programming
     */

    public int[] countBitsMe(int n) {
        int[] res = new int[n+1];
        int lastPowerOfTwo = 1;
        int nextPowerOfTwo = 1;
        res[0] = 0;
        for(int i=1;i<=n;i++){
            if(i == nextPowerOfTwo) {
                res[i] = 1;
                lastPowerOfTwo = i;
                nextPowerOfTwo*=2;
            }
            else res[i] = res[lastPowerOfTwo] + res[i-lastPowerOfTwo];
        }

        return res;
    }

    //leetcode solution
    class Solution {
        public int[] countBits(int n) {
            int[] bits = new int[n + 1];
            int highBit = 0;
            for (int i = 1; i <= n; i++) {
                if ((i & (i - 1)) == 0) {
                    highBit = i;
                }
                bits[i] = bits[i - highBit] + 1;
            }
            return bits;
        }
    }

}
