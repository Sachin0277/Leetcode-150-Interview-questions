public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }
    // Brute-force approach: Try all possible pairs of buy and sell days
    public int maxProfitBruteForce(int[] prices) {
        return calculate(prices, 0);
    }

    private int calculate(int[] prices, int start) {
        if (start >= prices.length) return 0;
        int max = 0;
        for (int i = start; i < prices.length; i++) {
            int maxProfit = 0;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > prices[i]) {
                    int profit = prices[j] - prices[i] + calculate(prices, j + 1);
                    if (profit > maxProfit) {
                        maxProfit = profit;
                    }
                }
            }
            if (maxProfit > max) {
                max = maxProfit;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockII solution = new BestTimeToBuyAndSellStockII();
        int[] prices = {7, 1, 5, 3, 6, 4};
        int maxProfit = solution.maxProfit(prices);
        System.out.println("Maximum Profit: " + maxProfit);
        int maxProfitBruteForce = solution.maxProfitBruteForce(prices);
        System.out.println("Maximum Profit (Brute Force): " + maxProfitBruteForce);


    }
    
}
