
public class BestTimeToBuyAndSellStock {
    public int maxProfitBruteforce(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
           minPrice = Math.min(minPrice, price);
           int profit = price - minPrice;
           maxProfit = Math.max(maxProfit, profit);
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        BestTimeToBuyAndSellStock solution = new BestTimeToBuyAndSellStock();
        int[] prices = {7, 1, 5, 3, 6, 4};
        int maxProfit = solution.maxProfitBruteforce(prices);
        System.out.println("Maximum Profit: " + maxProfit);
        int maxProfitOptimized = solution.maxProfit(prices);
        System.out.println("Maximum Profit (Optimized): " + maxProfitOptimized);
    }
}
