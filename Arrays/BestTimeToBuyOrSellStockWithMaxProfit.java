package Arrays;
/*
Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Total profit is 4 + 3 = 7
 */
public class BestTimeToBuyOrSellStockWithMaxProfit {
    public static int maxProfit(int[] prices) {
        int profit = 0;
        for(int i=1;i<prices.length;i++) {
            if(prices[i] > prices[i-1]) {
                profit += prices[i] - prices[i-1];
            }
        }
        return profit;
    }
    public static void main(String []args){
        int [] arr = new int[]{7,1,5,3,6,4};
        System.out.println("Max profit: " + maxProfit(arr));
    }
}
