package TwoPointers.Easy;

import java.util.Arrays;

/*
Assume you are an awesome parent and want to give your children some cookies. But, you should give
each child at most one cookie.

Each child i has a greed factor g[i], which is the minimum size of a cookie that the child will be
content with; and each cookie j has a size s[j]. If s[j] >= g[i], we can assign the cookie j to the
child i, and the child i will be content. Your goal is to maximize the number of your content children
and output the maximum number.

greed = [1,5,3,3,4]
size = [4,2,1,2,1,3]

Output: 3
As 1 in grid will 1 size in cookie
3 will take size 3
4 will take size 4

 */
public class AssignCookies {
    public static void main(String[] args){
        int[] greed={1,5,3,3,4};
        int[] sizeOfCookie = {4,2,1,2,1,3};

        System.out.println("Maximum cookie given to children: "+ maxCookieGiven(greed,sizeOfCookie));
        System.out.println("Maximum cookie given to children: "+ maxCookieGivenOptimal(greed,sizeOfCookie));
    }

    private static int maxCookieGiven(int[] greed, int[] sizeOfCookie) {
        Arrays.sort(greed);
        Arrays.sort(sizeOfCookie);

        int l=0,r=0;
        while(l<sizeOfCookie.length && r<greed.length){
            if(sizeOfCookie[l]>=greed[r]){
                l++;
                r++;
            }
            else
                l++;
        }
        return r;
    }
    private static int maxCookieGivenOptimal(int[] greed, int[] sizeOfCookie) {
        Arrays.sort(greed);
        Arrays.sort(sizeOfCookie);

        int child=0;
        for(int i=greed.length-1, j=sizeOfCookie.length-1;j>=0&&i>=0;i--){
            if(sizeOfCookie[j]>=greed[i])
            {
                child++;
                j--;
            }
        }
        return child;
    }
}
