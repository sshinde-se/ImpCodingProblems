package Arrays.Medium;

public class FindMaxConsecutiveOnes {
    public static void main(String []args){
        int [] arr = {1,1,0,1,1,1};
        System.out.println("Max Consecutive Ones: " + maxConsecutiveOnes(arr));
    }

    private static int maxConsecutiveOnes(int[] arr) {
        int cnt=0, max_cnt=0;
        for(int i: arr){
            if(i == 1)
                cnt++;
            else
                cnt = 0;
            if(cnt > max_cnt)
                max_cnt = cnt;
        }
        return max_cnt;
    }
}
