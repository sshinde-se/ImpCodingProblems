package Arrays;

public class SecondSmallestInArray {
    public static void main(String []args){
        int [] arr = new int[]{7,1,5,3,6,4};
        System.out.println("Second smallest: " + secondSmallestElement(arr));
    }

    private static int secondSmallestElement(int[] arr) {
        int min = Integer.MAX_VALUE;
        int second_min = min;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<min){
                second_min = min;
                min = arr[i];
            }
            else if(arr[i]<second_min && arr[i]!=min){
                second_min = arr[i];
            }
        }
        return second_min;
    }
}
