package 栈;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class 有效括号 {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                // 如果是左括号，压入栈
                stack.push(c);
            } else {
                // 如果是右括号，检查栈是否为空以及括号是否匹配
                if (stack.isEmpty() || !map.get(stack.pop()).equals(c)) {
                    return false;
                }
            }
        }
        // 遍历完字符串后，检查栈是否为空
        return stack.isEmpty();
    }

}
