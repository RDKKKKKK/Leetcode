package 哈希表;

import java.util.HashMap;
import java.util.Map;

public class 最长连续序列 {
    public int longestConsecutive(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            map.put(num, 1);
        }
        int max = 0;
        for (int num : nums){
            int cur = 1;
            if (!map.containsKey(num-1)){
            while (map.containsKey(num+1)){
                cur++;
                num++;
            }
            if (cur>max)
                max =cur;}
        }
        return max;
    }

    /*
    public int longestConsecutive(int[] nums) {
        int[] dp = new int[100000]; // the max consecutive length ending with index
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            if (!map.containsKey(num)){
                map.put(num, 1);
                if (num>0)
                    dp[num] = dp[num+1] + dp[num-1] + 1;
                else
                    dp[num] = 1;
                if(dp[num] > max)
                    max = dp[num];
            }
        }
        return max;
    }*/
}
