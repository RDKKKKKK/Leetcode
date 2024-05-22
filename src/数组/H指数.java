package 数组;

public class H指数 {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int current_n = 0;
        for (int i = 0; i < n; i++) {
            if (citations[i] >= current_n + 1){
                current_n++;
            }
            if(n - 1 - i < current_n){ //剩下的可能引用 小于 达到当前H指数仍需要的值
                return current_n;
            }
        }
        return current_n;
    }
}
