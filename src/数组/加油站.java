package 数组;

public class 加油站 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int[] reach = new int[n]; //在该站点能到达下一点最少需要拥有的汽油
        int accum = 0, check = 0;
        int start = 0;
        int flag = 0;
        for (int i = 0; i < n; i++) {
            reach[i] = gas[i] - cost[i];
            accum+=reach[i];
            if (reach[i] >= 0 && flag==0) {
                start = i;
                accum = reach[i];
                flag = 1;
            }
            if (accum < 0 && flag==1) {
                start = (i + 1) % 5;
                flag = 0;
            }
            if (accum < 0 && i == n-1 && flag==0)
                return -1;
        }
        check = accum;
        for (int i = 0; i < start; i++) {
            check += reach[i];
            if (check < 0)
                return -1;
        }
        return start;
    }
}
