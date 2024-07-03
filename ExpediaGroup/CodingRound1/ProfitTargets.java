package ExpediaGroup.CodingRound1;

import java.util.*;

/*
stockProfit = [5,7,9,13,11,6,6,3,3]
target=12

there are 4 pairs that have sum 12 i.e (5,7),(9,3),(9,3),(6,6)
but remove matching pairs hence output is 3.
 */
public class ProfitTargets {

    private static int findPairsWithTargetSum(List<Integer> stockProfit, int target) {
        Collections.sort(stockProfit);
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int cntSum=0;
        for(int i=0;i<stockProfit.size();i++){
            for(int j=i+1;j<stockProfit.size();j++){
                if(stockProfit.get(i) + stockProfit.get(j) == target){
                    if(!(hmap.containsKey(stockProfit.get(i)) && hmap.containsValue(stockProfit.get(j))) ||
                            (hmap.containsKey(stockProfit.get(j)) && hmap.containsValue(stockProfit.get(i)))){
                        hmap.put(stockProfit.get(i), stockProfit.get(j));
                        cntSum++;
                    }
                }
            }
        }
        return cntSum;
    }
    private static int findPairsWithTargetSumEfficient(List<Integer> stockProfit, int target) {
        Collections.sort(stockProfit);
        int cntSum=0;
        int low=0;
        int high=stockProfit.size()-1;
        while(low<high){
            if(stockProfit.get(low) + stockProfit.get(high) == target){
                low++;
                high--;
                cntSum++;
            }
            else if((stockProfit.get(low) + stockProfit.get(high)) < target)
                low++;
            else
                high--;
        }
        return cntSum;
    }

    public static void main(String[] args){
        int[] profit = {5,7,9,13,11,6,6,3,3};
        List<Integer> stockProfit = new ArrayList<>();
        for (int j : profit) {
            stockProfit.add(j);
        }
        int target = 12;
        System.out.println("My Solution:"+ findPairsWithTargetSum(stockProfit, target));
        System.out.println("Efficient Solution:"+ findPairsWithTargetSumEfficient(stockProfit, target));

        int[] profit1 = {1,3,46,1,3,9};
        List<Integer> stockProfit1 = new ArrayList<>();
        for (int j : profit1) {
            stockProfit1.add(j);
        }
        int target1 = 12;
        System.out.println("My Solution:"+ findPairsWithTargetSum(stockProfit1, target1));
        System.out.println("Efficient Solution:"+ findPairsWithTargetSumEfficient(stockProfit1, target1));
    }
}
