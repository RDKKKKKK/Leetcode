package 回溯;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 电话号码字母组合 {
    public List<String> letterCombinations(String digits) {
        Map<Integer, List<Character>> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        for (int i = 2; i < 8; i++) {
            List<Character> now = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                now.add((char) ('a' + (i - 2)*3 + j));
            }
            map.put(i, now);
        }
        List<Character> now = new ArrayList<>();
        for (int j = 0; j < 4; j++) {
            now.add((char) ('a' + (9 - 2)*3 + j));
        }
        map.put(9, now);
        backtracking(0, res, "", map, digits);
        return res;
    }

    public void backtracking(int index, List<String> res, String cur, Map<Integer, List<Character>> map, String digits){
        if (index == digits.length()-1){
            res.add(cur);
            return;
        }

        int now = (int)digits.charAt(index);
        for (Character c : map.get(now)){
            cur += c;
            backtracking(index+1, res, cur, map, digits);
            cur = cur.substring(0, cur.length()-2);
        }
    }
}
