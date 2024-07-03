package PerforceCompany;

import java.util.*;

//List<String> inputList = {"dog","cat","god","act","pet"};
//Set<Set<String>> output = {{"dog","god"},{"cat","act"},{"pet"}}
public class GroupOfAnagramSecondRound {
    public static void main(String[] args) {
        List<String> inputList = Arrays.asList("dog", "cat", "god", "act", "pet");
        Set<Set<String>> output = groupOfAnagramUsingInbuiltMethod(inputList);
        System.out.println(output);

        Set<Set<String>> output1 = groupOfAnagramUsingMySolution(inputList);
        System.out.println(output1);
    }

    private static Set<Set<String>> groupOfAnagramUsingMySolution(List<String> inputList) {
        Set<Set<String>> finalSet = new HashSet<>();
        Set<String> setOfSameString= new HashSet<>();
        setOfSameString.add(inputList.get(0));
        finalSet.add(setOfSameString);
        for(int i=1;i<inputList.size();i++){
            char [] ch = inputList.get(i).toCharArray();
            Arrays.sort(ch);
            String stmp = new String(ch);
            boolean check=false;
            for(Set<String> sets: finalSet){
                char [] chset = sets.stream().findFirst().get().toCharArray();
                Arrays.sort(chset);
                String s1tmp = new String(chset);
                if(stmp.equals(s1tmp)){
                    sets.add(inputList.get(i));
                    check = true;
                }
            }
            if(!check){
                Set<String> setOfSameString1= new HashSet<>();
                setOfSameString1.add(inputList.get(i));
                finalSet.add(setOfSameString1);
            }
        }
        return finalSet;
    }

    private static Set<Set<String>> groupOfAnagramUsingInbuiltMethod(List<String> inputList){
        Map<String, Set<String>> anagramGroups = new HashMap<>();

        // Group strings by their sorted characters
        for (String str : inputList) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);

            // Add the string to its corresponding anagram group
            Set<String> group = anagramGroups.getOrDefault(sortedStr, new HashSet<>());
            group.add(str);
            anagramGroups.put(sortedStr, group);
        }
        return new HashSet<>(anagramGroups.values());
    }
}


