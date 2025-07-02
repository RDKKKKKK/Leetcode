package leetcode_75;

import java.util.Stack;

public class AsteroidCollision_735 {
    /**
     * 右边行星不停向左边碰撞直至被毁灭才停下
     * 栈 后进先出特性可以满足不断与左边比较
     */
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {

            int cur = asteroids[i];

            if (stack.isEmpty() || cur > 0)
                stack.push(cur);
            else {
                boolean destroy = false;
                while ( !stack.isEmpty() && stack.peek() > 0 ) {
                    int left = stack.pop();
                    if (left + cur > 0) {
                        stack.push(left);
                        destroy = true;
                        break;
                    }
                    if (left + cur == 0){
                        destroy = true;
                        break;
                    }
                }

                if (!destroy) stack.push(cur);
            }
        }

        int n = stack.size();
        int[] res = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }

        return res;
    }
}
