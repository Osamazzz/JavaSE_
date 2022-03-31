package LeetCode_.DP;

/**
 * @author Obamazzz
 * @version 1.0
 * 假设把某股票的价格按照时间先后顺序存储在数组中，
 * 请问买卖该股票一次可能获得的最大利润是多少？
 */
public class maxProfitTest {
    public int maxProfit01(int[] prices) {
        //动态规划
        //初始化第一天
        int dp = 0;
        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < i; j++) {
                //做差，如果差价比前面的大则更新
                dp = Math.max(dp, prices[i] - prices[j]);
            }
        }
        return dp;
    }

    public int maxProfit02(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        //动态规划
        //记录第i天最大差价，若为负数则记为0
        int[] dp = new int[prices.length];
        dp[0] = 0;
        int max = 0;
        //第i天前的最低价格
        int min = prices[0];
        for (int i = 1; i < dp.length; i++) {
            //更新最低价格
            min = Math.min(min, prices[i]);
            //如果差价大于0则记录
            dp[i] = Math.max(prices[i] - min, 0);
            //更新最大差价
            max = Math.max(max,dp[i]);
        }
        return max;
    }
    //cost记录第i天前最低价格
    //dp[i]=max(dp[i−1],prices[i]−min(cost,prices[i])
    //profit=max(profit,prices[i]−min(cost,prices[i])
    public int maxProfit03(int[] prices) {
        int cost = Integer.MAX_VALUE, profit = 0;
        for(int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }
}
