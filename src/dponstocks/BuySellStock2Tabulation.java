package dponstocks;

import java.util.Arrays;

public class BuySellStock2Tabulation {

	private long getMaxProfit(int[] values) {
		long[][] dp = new long[values.length + 1][2];
		for (int i = 0; i < values.length; i++) {
			Arrays.fill(dp[i], 0);
		}
		int n = values.length;
		long profit = 0;
		for (int ind = n - 1; ind >= 0; ind--) {
			for (int buy = 1; buy >= 0; buy--) {
				if (buy == 1) {
					long buyTake = -values[ind] + dp[ind + 1][0];
					long buyNotTake = 0 + dp[ind + 1][1];
					profit = Math.max(buyTake, buyNotTake);
				} else {
					long sellTake = values[ind] + dp[ind + 1][1];
					long sellNotTake = 0 + dp[ind + 1][0];
					profit = Math.max(sellTake, sellNotTake);
				}
				dp[ind][buy] = profit;
			}

		}

		return dp[0][1];

	}

	public static void main(String[] args) {

		int values[] = { 7, 1, 5, 3, 6, 4 };
		// int values[] = { 4, 6 };
		BuySellStock2Tabulation buySellStock2Tabulation = new BuySellStock2Tabulation();
		long maxProfit = buySellStock2Tabulation.getMaxProfit(values);
		System.out.println(maxProfit);

	}

}
