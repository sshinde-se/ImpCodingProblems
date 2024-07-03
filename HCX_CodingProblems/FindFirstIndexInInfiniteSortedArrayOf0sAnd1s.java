package HCX_CodingProblems;

public class FindFirstIndexInInfiniteSortedArrayOf0sAnd1s {
    int findFirstIndex(int []arr){
        int l=0,h=1;
        while(arr[h]==0) {
            l = h;
            h = 2 * h;
        }
        return indexOfFirstOne(arr, l, h) +1;
    }
    int indexOfFirstOne(int []arr, int low, int high)
    {
        int mid=0;
        while (low <= high) {
            mid = (low + high) / 2;

            if (arr[mid] == 1 && (mid == 0 || arr[mid - 1] == 0))
                break;

            else if (arr[mid] == 1)
                high = mid - 1;

            else
                low = mid + 1;
        }
        return mid;
    }
    /*
    As Array is sorted we can use binary search,
    but the length of array is infinite, so we take start = 0 and end = 1.
    After that loop till we get array value 0 and change start(l) and end(h) like below
    if it is true then change l = h and h = 2 * h and apply binary search.

    Complexity will be: O(logN)
     */
    public static void main(String[] args) {
        int []arr = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1};
        FindFirstIndexInInfiniteSortedArrayOf0sAnd1s t1 = new FindFirstIndexInInfiniteSortedArrayOf0sAnd1s();
        System.out.println(t1.findFirstIndex(arr));
    }
}
