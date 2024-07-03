package ServiceNowCoding;

public class StockBuyOrSellToMaximizeProfit {
    public static void main(String[] args){
        int[] arr = new int[]{4,2,2,2,4};
        System.out.println(getMaxProfit(arr));
        int[] arr1 = new int[]{100, 180, 260, 310, 40, 535, 695};
        System.out.println(getMaxProfit(arr1));
    }

    private static int getMaxProfit(int[] arr) {
        int price = 0;
        for(int i=0; i+1<arr.length;i++){
            if(arr[i+1] > arr[i])
                price += arr[i+1]-arr[i];
        }
        return price;
    }
}
