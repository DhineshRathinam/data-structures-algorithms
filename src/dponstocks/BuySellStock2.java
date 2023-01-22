package dponstocks;

import java.util.Arrays;

public class BuySellStock2 {

	private long f(int ind, int buy, int n, int[] values, long[][] dp) {
		// Base cases
		if (ind == n) {
			return 0;
		}
		if (dp[ind][buy] != -1) {
			return dp[ind][buy];
		}
		long profit = 0;
		if (buy == 1) {
			long buyTake = -values[ind] + f(ind + 1, 0, n, values, dp);
			long buyNotTake = 0 + f(ind + 1, 1, n, values, dp);
			profit = Math.max(buyTake, buyNotTake);
		} else {
			long sellTake = values[ind] + f(ind + 1, 1, n, values, dp);
			long sellNotTake = 0 + f(ind + 1, 0, n, values, dp);
			profit = Math.max(sellTake, sellNotTake);
		}
		dp[ind][buy] = profit;
		return profit;
	}

	private long getMaxProfit(int[] values) {
		long[][] dp = new long[values.length][2];
		for (int i = 0; i < values.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		return f(0, 1, values.length, values, dp);
	}

	public static void main(String[] args) {
		//int values[] = { 7, 1, 5, 3, 6, 4 };
		// int values[] = { 4, 6 };
		int values[] = { 7, 1, 5, 3 };
		BuySellStock2 buySellStock2 = new BuySellStock2();
		long maxProfit = buySellStock2.getMaxProfit(values);
		System.out.println(maxProfit);
	}
}
