package 栈;

import java.util.Stack;

public class 逆波兰表达式 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens){
            //negative value need to be considered
            if(Integer.parseInt(s) >=0 && Integer.parseInt(s)<=9){
                stack.push(Integer.valueOf(s));
            }
            else {
                int a = stack.pop();
                int b = stack.pop();

                // use equals() <- == is comparing reference
                if (s == "*") stack.push(a*b);
                if (s == "/") stack.push(a/b);
                if (s == "+") stack.push(a+b);
                if (s == "-") stack.push(a-b);

            }
        }
        return stack.pop();
    }
}
