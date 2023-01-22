package dponstocks;

import java.util.Arrays;

public class BuySellStockKTransTabulation {

	private int maxProfit(int[] prices, int totalTransactions) {

		// Define the dp array

		int[][] dp = new int[totalTransactions + 1][prices.length + 1];
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], 0);
		}

		for (int i = 1; i <= totalTransactions; i++) {
			for (int j = 1; j < prices.length; j++) {
				int notTake = dp[i][j - 1];

				int maxi = 0;
				for (int m = 0; m < j; m++) {
					int pricetMthDay = prices[j] - prices[m] + dp[i - 1][m];
					maxi = Math.max(maxi, pricetMthDay);
				}
				dp[i][j] = Math.max(notTake, maxi);
			}
		}

		return dp[totalTransactions][prices.length - 1];
	}

	public static void main(String[] args) {
		int[] prices = { 2, 5, 7, 1, 4, 3, 1, 3 };

		BuySellStockKTransTabulation kTransTabulation = new BuySellStockKTransTabulation();

		int result = kTransTabulation.maxProfit(prices, 3);
		System.out.println(result);
	}

}
