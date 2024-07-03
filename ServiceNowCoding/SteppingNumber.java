package ServiceNowCoding;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
Given two integers ‘n’ and ‘m’, find all the stepping numbers in range [n, m].
A number is called stepping number if all adjacent digits have an absolute difference
of 1. 321 is a Stepping Number while 421 is not.
 */
public class SteppingNumber {
    public static void main(String[] args){
        int m=0, n=21;
        System.out.println(steppingNumbers(m,n));
        for(int i=0;i<=9;i++){
            usingBFS(m, n, i);
        }
        System.out.println();
        int m1=12, n1=100;
        System.out.println(steppingNumbers(m1,n1));
        for(int i=0;i<=9;i++){
            usingBFS(m1, n1, i);
        }
    }

    private static ArrayList<Integer> steppingNumbers(int m, int n) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i=m; i<=n; i++){
            if(i<=9)
                arrayList.add(i);
            else if(calDigitDiff(i))
                arrayList.add(i);
        }
        return arrayList;
    }

    private static boolean calDigitDiff(int i) {
        int prev=i%10;
        i = i/10;
        while(i>0){
            int d=i%10;
            if(Math.abs(prev-d) != 1){
                return false;
            }
            prev=d;
            i=i/10;
        }
        return true;
    }
    private static void usingBFS(int n, int m, int num) {
        Queue<Integer> q = new LinkedList<Integer>();

        q.add(num);

        while (!q.isEmpty()) {
            // Get the front element and pop from the queue
            int stepNum = q.poll();

            // If the Stepping Number is in the range [n,m] then display
            if (stepNum <= m && stepNum >= n)
                System.out.print(stepNum + " ");

            // If Stepping Number is 0 or greater then m, no need to explore the neighbors
            if (stepNum == 0 || stepNum > m)
                continue;

            // Get the last digit of the currently visited Stepping Number
            int lastDigit = stepNum % 10;

            // There can be 2 cases either digit to be appended is lastDigit + 1 or lastDigit - 1
            int stepNumA = stepNum * 10 + (lastDigit - 1);
            int stepNumB = stepNum * 10 + (lastDigit + 1);

            // If lastDigit is 0 then only possible digit after 0 can be 1 for a Stepping Number
            if (lastDigit == 0)
                q.add(stepNumB);

                // If lastDigit is 9 then only possible digit after 9 can be 8 for a Stepping Number
            else if (lastDigit == 9)
                q.add(stepNumA);

            else {
                q.add(stepNumA);
                q.add(stepNumB);
            }
        }
    }
}
