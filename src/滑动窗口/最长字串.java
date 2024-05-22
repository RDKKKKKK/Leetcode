package 滑动窗口;

import java.util.HashMap;
import java.util.Map;

public class 最长字串 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, max = 0, cur = 0;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (!map.containsKey(c) || map.get(c) < start) {
                map.put(c, i);
                cur++;
                max = Math.max(max, cur);

            }
            else {
                max = Math.max(max, cur);
                start = map.get(c) + 1;
                cur = i - start + 1;
                map.put(c, i);
            }
        }
        return max;
    }
}
