package ServiceNowCoding;
import java.util.Arrays;
import java.util.Random;

public class ShuffleSongsOrNumbersInArray {
    public static void main(String [] args){
        int[] arr= new int[]{1,2,3,4,5,6,7,8};
        System.out.println(Arrays.toString(shuffleArray(arr)));
    }

    private static int[] shuffleArray(int[] arr) {
        Random r = new Random();
        for(int i=arr.length-1; i>0;i--){
            int j=r.nextInt(i);// it randomly generates number from 0 to i

            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        return arr;
    }
}
