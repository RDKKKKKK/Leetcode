package 贪心算法;

import java.util.Arrays;

public class 分发饼干 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i=0, j=0;
        int count = 0;
        while (i < g.length && j < s.length){
            if (g[i] <= s[i]) {
                i++;
                j++;
                count++;
            }
            else
                j++;
        }

        return count;
    }
}

