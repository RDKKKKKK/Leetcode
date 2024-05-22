package 数组;

/**
 * 贪心算法：
 * 找到不重叠的多段 可以把每段视为一段的累加（今天减昨天）
 * 从而使用贪心算法从第一天开始，只要下一天比这一天低 就计入总值
 */

public class 股票2 {
    public int maxProfit(int[] prices) {
        int count = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1])
                count += prices[i] - prices[i-1];
        }
        return count;
    }
}
