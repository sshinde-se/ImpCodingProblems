package Graphs.DFS_BFS_Problems;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HWordLadderI {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));
        wordList.remove(beginWord);

        while(!q.isEmpty()){
            String word = q.peek().s;
            int steps = q.peek().steps;
            q.remove();

            if(word.equals(endWord))
                return steps;

            for(int i=0;i<word.length();i++){
                for(char ch='a'; ch <= 'z'; ch++){
                    String replace_word = word.substring(0,i) + ch + word.substring(i+1);
                    if(wordList.contains(replace_word)){
                        wordList.remove(replace_word);
                        q.add(new Pair(replace_word,steps+1));
                    }
                }
            }
        }
        return 0;
    }
}
class Pair{
    String s;
    int steps;
    Pair(String s, int steps){
        this.s = s;
        this.steps = steps;
    }
}