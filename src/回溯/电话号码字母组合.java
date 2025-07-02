package 回溯;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *      直接定义映射更快
 *     private static final String[] MAPPING = {
 *         "",     // 0
 *         "",     // 1
 *         "abc",  // 2
 *         "def",  // 3
 *         "ghi",  // 4
 *         "jkl",  // 5
 *         "mno",  // 6
 *         "pqrs", // 7
 *         "tuv",  // 8
 *         "wxyz"  // 9
 *     };
 */

public class 电话号码字母组合 {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;
        backtrack(digits, 0, new StringBuilder(), res);
        return res;
    }

    public void backtrack(String digits, int index, StringBuilder cur, List<String> res){
        if (index >= digits.length()){
            res.add(cur.toString());
            return;
        }

        char c = digits.charAt(index);

        System.out.println(c);

        int cNumber = Integer.valueOf(c) - '0';
        int limit = 3;
        int diff = (cNumber - 2)*3;

        if (cNumber == 8) diff++;
        if (cNumber == 7) limit++;
        if (cNumber == 9) {
            limit++; diff++;
        }

        System.out.println(diff);

        for (int i = 0; i < limit; i++) {
            char now = (char) ('a' + diff + i);
            System.out.println(diff + " " + now);
            cur.append(""+now);
            backtrack(digits, index+1, cur, res);
            cur.deleteCharAt(cur.length()-1);
        }
    }


    public List<String> letterCombinations1(String digits) {
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
