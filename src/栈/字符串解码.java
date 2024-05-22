package 栈;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 字符串解码 {
    public String decodeString(String s){
        Queue<Character> queue = new LinkedList<>();
        for (Character c:s.toCharArray()){
            queue.offer(c);
        }

        return decodeQueueString(queue);
    }

    private String decodeQueueString(Queue<Character> queue) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        while (!queue.isEmpty()){
            Character c = queue.poll();
            if (Character.isDigit(c)){
                num = num*10 + Integer.valueOf(c);
            }
            if (c.equals('[')){
                String tmp = decodeQueueString(queue);
                for (int i = 0; i < num; i++) {
                    sb.append(tmp);
                }
            }
            if (c.equals(']'))
                return sb.toString();
            else
                sb.append(c);
        }

        return "";
    }

    public String decodeString2(String s){
        Character c = s.charAt(0);
        int index = 0;
        String res = "";
        if (Character.isDigit(c)){
            for (int i = s.length()-1; i >=0 ; i++) {
                if (s.charAt(i) == ']'){
                    index = i;
                    break;
                }
            }
            String sub = s.substring(2, index);
            boolean over = true;
            for (int i = 0; i < sub.length(); i++) {
                if (sub.charAt(i) == '[') over = false;
            }
            if (over){
                for (int i = 0; i < c; i++) {
                    res+=sub;
                }
                return res;
            }
            else {
                res += decodeString(sub);
                return res;
            }
        }
        else {
            int start = 0;
            for (int i = 0; i<s.length(); i++) {
                res += String.valueOf(s.charAt(i));
                if (Character.isLetter(s.charAt(i))){
                    start = i;
                    break;
                }
            }
            res += decodeString(s.substring(start,s.length()-1));
            return res;
        }
    }


    public String decodeString1(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        String cur = "";
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c - 'a' <= 26 && c - 'a' >= 0) {
                cur += String.valueOf(c);
            } else if (c.equals(']')) {
                String top = stack.pop();
                StringBuilder tmp = new StringBuilder();
                stack.pop();
                int num = Integer.parseInt(stack.pop());
                for (int j = 0; j < num; j++) {
                    tmp.append(top);
                }
                if (stack.isEmpty())
                    res.append(top);
                else
                    stack.push(top);
            } else {
                if (!cur.equals("")) {
                    stack.push(cur);
                    cur = "";
                }
                stack.push(String.valueOf(c));
            }
        }
        if (!cur.equals(""))
            res.append(cur);

        return res.toString();
    }
}