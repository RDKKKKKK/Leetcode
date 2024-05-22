package 堆;

import java.util.Stack;


//栈里存两个元素：数本身 和 数在栈里的时候栈的最小值

class MinStack {

    // 数组栈, [当前值, 当前最小值]
    private Stack<int[]> stack = new Stack<>();

    public MinStack() {

    }

    public void push(int x) {
        if (stack.isEmpty()){
            stack.push(new int[]{x, x});
        }else {
            stack.push(new int[]{x, Math.min(x, stack.peek()[1])});
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
}
