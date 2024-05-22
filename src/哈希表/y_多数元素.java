package 哈希表;

import java.util.HashMap;
import java.util.Map;

public class y_多数元素 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map=new HashMap<>();
        int thres = nums.length/2;
        int max = 0, key=0, cur_count=0;
        for(Integer num:nums){
            if(!map.containsKey(num))
                map.put(num,1);
                cur_count = map.get(num);
                if(cur_count>thres && cur_count>max) {
                    max = cur_count;
                    key = num;
                }
            else{
                cur_count = map.get(num);
                cur_count++;
                map.put(num, cur_count);
                if(cur_count>thres && cur_count>max) {
                    max = cur_count;
                    key = num;
                }
            }
        }
        return key;
    }
}
