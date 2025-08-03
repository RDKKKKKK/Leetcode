package leetcode_75;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters_3 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0, res = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);

            if(!map.containsKey(c)){
                map.put(c,i);
                res = Math.max(i-start+1, res);
                continue;
            }

            int newStart = map.get(c)+1;
            for(int j=start;j<newStart;j++){
                map.remove(s.charAt(j));
            }

            map.put(c, i);
            start = newStart;
        }

        res = Math.max(s.length() - start, res);

        return res;
    }
}
