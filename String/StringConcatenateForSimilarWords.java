package String;

/******************************************************************************

You are given a vector of strings you are supposed to concatenate their occurrences if they occur more than once

*******************************************************************************/

public class StringConcatenateForSimilarWords
{
    public static void main(String [] args){
    	String [] arr = new String[]{"tv", "musicPlayer", "microwave", "tv", "mediaPlayer", "tv"};
    	for(int i=0;i< arr.length;i++){
    	    int cnt=1;
    	    for(int j=i+1; j<arr.length;j++){
    	        if(arr[i].equals(arr[j])){
    	            arr[j] = arr[i] + cnt;
    	            cnt++;
    	        }
    	    }
    	}
		for (String s : arr) {
			System.out.println(" " + s);
		}

    }
}
