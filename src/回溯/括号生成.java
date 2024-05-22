package 回溯;

import java.util.ArrayList;
import java.util.List;

/*
    直接用List<String> + "（" 不需要从List<Character>转
 */

public class 括号生成 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        List<Character> path = new ArrayList<>();
        path.add('(');
        backtracking(res, path, n);
        return res;
    }

    public void backtracking(List<String>res, List<Character> path, int n){
        if (path.size() == n*2){
            StringBuffer sb = new StringBuffer();
            for (Character c : path) sb.append(c);
            String s = sb.toString();
            res.add(s);
            return;
        }

        int leftNum = 0;
        int rightNum = 0;
        for (Character c:path){
            if (c.equals('(')) leftNum++;
            if (c.equals(')')) rightNum++;
        }

        if (leftNum > rightNum) {
            path.add(')');
            backtracking(res, path, n);
            path.remove(path.size() - 1);
        }

        if (leftNum < n){
            path.add('(');
            backtracking(res, path, n);
            path.remove(path.size() - 1);
        }

    }
}
