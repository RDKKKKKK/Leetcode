package 数组;

public class 股票 {
    /**
     * old：嵌套for循环，考虑所有的买入卖出情形 超时
     * new：分成小段考虑：找到局部的最低价，再计算局部最大利益，如果该段最大利益更大则更新
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max_profit = 0;
        for (int price : prices) {
            if (price < min)
                min = price;
            else if(price - min > max_profit)
                max_profit = price - min;
        }
        return max_profit;
    }
}
