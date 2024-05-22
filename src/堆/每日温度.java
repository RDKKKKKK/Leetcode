package 堆;

import java.util.ArrayDeque;
import java.util.Deque;

public class 每日温度 {
    /**
     * 栈里存index就可以了，想知道具体温度的时候直接temperatures[index]
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Deque<int[]> stack = new ArrayDeque<>();

        for(int i = 0; i<temperatures.length; i++){

            int[] cur = new int[2];
            cur[0] = temperatures[i];
            cur[1] = i;

            while(!stack.isEmpty() && stack.peek()[0] < temperatures[i]){
                int[] top = stack.pop();
                res[top[1]] = i - top[1];
            }

            stack.push(cur);
        }

        while(!stack.isEmpty()){
            res[stack.pop()[1]] = 0;
        }

        return res;
    }
}
