package GoldmanSachs.CodingRound;

import java.util.PriorityQueue;
/*
* Question:
	Given a Pattern containing only Ns and M’s . N represents ascending and M represents descending , Each character (M or
	N) needs to display sequence of numbers(2 numbers) explaining the ascending or descending order (for ex: 21 -
	>represents descending -> M) . The second character in the pattern takes the last digit from first character and builds the
	sequence and so on..Please look at example section below.
	There could be multiple numbers satisfying the pattern. The goal is to find out the lowest numeric value following the
	pattern.
	Constraints:
	Input can have maximum 8 characters
	Output can have Digits from 1-9 and Digits can’t repeat.
	In case of no possible output or incorrect input value (like blank /null /NON M or N character) please return -1.
	Example Section:
	Input : M
	Output: 21 (2 -> 1 shows descending and possible smallest numeric value. Even 65 or 74 can qualify, but 21 being the
	smallest numeric value is the correct answer)
	Input : MNM
	Output:2143 (M represents descending 2->1 , N represents ascending 1->4 (1 is coming from last character) , M
	represents descending 4->3(4 is coming from last character sequence) -- There would be many number qualifying the
	pattern like 3142 ,8796,6241 etc.. 2143 is the lowest numeric value for this pattern sequence.)
 */
public class MNStringSolution {
    static PriorityQueue<Integer> queue = new PriorityQueue<>();
    static int findPossibleSmallestMatchingPattern(String pattern){
        if(pattern.equals("") || pattern == "" || pattern == " " || pattern == null
                || getCount(pattern) != pattern.length())
            return -1;
        String res="";
        int len=pattern.length();
        for(int i=1;i<=len+1;i++)
            queue.add(i);
        int mcnt=0,ncnt=0;
        for (int i=0;i<len;i++){
            if(pattern.charAt(i) == 'M'){
                mcnt = getConsecutiveCount(pattern, i, 'M');
                res += getElement(mcnt+1);
                mcnt=0;
            }
            else {
                res += getElement(1);
                ncnt = 0;
            }
        }
        return Integer.parseInt(res+queue.poll());
    }

    private static int getCount(String pattern) {
        int mcnt=0,ncnt=0;
        for(int i=0;i<pattern.length();i++){
            if(pattern.charAt(i) == 'M')
                mcnt++;
            if(pattern.charAt(i) == 'N')
                ncnt++;
        }
        return mcnt+ncnt;
    }

    private static int getConsecutiveCount(String pattern, int index, char ch) {
        int cnt=0;
        for(int i=index; i<pattern.length();i++){
            if(pattern.charAt(i) == ch)
                cnt++;
            else
                break;
        }
        return cnt;
    }
    private static String getElement(int i) {
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        int tmp=0,cnt=0;
        while (i-->0){
            tmp = queue.poll();
            cnt++;
            if(i>0)
                pq.add(tmp);
            else
                break;
        }
        queue.addAll(pq);
        return tmp+"";
    }
    public static void main(String [] args){
        String s="MNM";
        System.out.println(findPossibleSmallestMatchingPattern(s));
    }
}
