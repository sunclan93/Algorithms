package Algorithms.Lintcode.DataStructure;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        // write your code here
        int[] prefix = new int[prices.length];
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                prefix[i] = prices[i];
            }
            else {
                res = Math.max(res, prices[i] - prefix[i - 1]);
                prefix[i] = Math.min(prefix[i - 1], prices[i]);
            }

        }
        return res;
    }
    /*
    *  Not using prefix arrays
    * */
    public int maxProfitV2(int[] prices) {
        // write your code here
        int[] prefix = new int[prices.length];
        int res = 0;
        int pre = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                pre = prices[i];
            }
            else {
                res = Math.max(res, prices[i] - pre);
                pre = Math.min(pre, prices[i]);
            }

        }
        return res;
    }
}
