package practiceproblems;

public class BestTimeToBuyAndSellStock {
	public static void main(String[] args) {
		int[] prices = {7,1,5,3,6,4};
		BestTimeToBuyAndSellStock bss = new BestTimeToBuyAndSellStock();
		bss.maxProfit(prices);
	}
	
	public int maxProfit(int[] prices) {
		if (prices != null) {
			int smallPrice = prices[0];
			int maxPrice = prices[0];
			for (int i = 0; i < prices.length; i++) {
				if (prices[i] < smallPrice) {
					smallPrice = prices[i];
					maxPrice = prices[i];
				} else if(prices[i] > maxPrice) {
					maxPrice = prices[i];
				}
			}
			return maxPrice - smallPrice;
		} else {
			return 0;
		}
	}
}
