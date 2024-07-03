package PerforceCompany;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
input : This sentence contains two words or contains more than 2 words, one contains two
output : [two -> 2, contains -> 3, words->2 ]
 */
public class StringProgram {
    public static void main(String[] args){
        String s= "This sentence contains two words or contains more than 2 words, one contains two";
        String []str=s.split(" ");
        Map<String, Integer> map= new HashMap<>();
        for (String value : str) {
            if (!map.containsKey(value)) {
                map.put(value, 1);
            } else {
//                for(Map.Entry<String, Integer> en: map.entrySet()){
//                    if(en.getKey().equals(str[i])){
//                        map.put(str[i], en.getValue()+1);
//                    }
//                    else
//                    {
//                        map.put(str[i], 1);
//                    }
//                }
                map.put(value, map.get(value) + 1);
            }
        }

        System.out.println(map);
    }
}
