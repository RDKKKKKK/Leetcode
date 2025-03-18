package 哈希表;

import java.util.HashSet;
import java.util.Set;


//不是快乐数->无限循环->sum重复出现->hashset
public class y_p_快乐数 {

    //获取每一位的平方和
        private int getNext(int n) {
            int totalSum = 0;
            while (n > 0) {
                int d = n % 10;
                n = n / 10;
                totalSum += d * d;
            }
            return totalSum;
        }

        //判断是否进入死循环
        public boolean isHappy(int n) {
            Set<Integer> seen = new HashSet<>();
            while (n != 1 && !seen.contains(n)) {
                seen.add(n);
                n = getNext(n);
            }
            return n == 1;
        }
}
