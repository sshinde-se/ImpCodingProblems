package Arrays;

public class BestTimeToBuyOrSellStock {
    public static int maxProfitEfficient(int[] prices) {
        int min=Integer.MAX_VALUE;
        int profit=0;
        int stockDiff=0;
        for (int price : prices) {
            if (price < min) {
                min = price;
            }
            stockDiff = price - min;
            if (profit < stockDiff) {
                profit = stockDiff;
            }
        }
        return profit;
    }
    public static void main(String []args){
        int [] arr = new int[]{7,1,5,3,6,4};
        System.out.println("Max profit: " + maxProfitEfficient(arr));
        System.out.println("Max profit: " + maxProfitMySolution(arr));
    }
    public static int maxProfitMySolution(int[] prices) {
        int min=prices[0];
        int day=0;
        for(int i=0; i<prices.length; i++){
            if(prices[i]<min && i!=prices.length-1){
                min = prices[i];
                day = i;
            }
        }
        int max = prices[day];
        for(int i=day+1; i<prices.length; i++){
            if(prices[i]>max){
                max = prices[i];
            }
        }
        return max-min;
    }
}
