package HashMap; /******************************************************************************


sort HashMap using values

*******************************************************************************/
import java.util.*;
import java.util.stream.Collectors;

public class SortHashMapUsingValues {
	public static void main(String[] args) {
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		hm.put("Math", 98);
        hm.put("Data Structure", 85);
        hm.put("Database", 91);
        hm.put("Java", 95);
        hm.put("Operating System", 79);
        hm.put("Networking", 80);
        
        Map<String, Integer> newHm = sortedHashMap(hm);
        for (Map.Entry<String, Integer> en : newHm.entrySet()) {
            System.out.println("Key = " + en.getKey() + 
                          ", Value = " + en.getValue());
        }
        System.out.println();
        Map<String, Integer> newHm1 = sortedHashMapUsingLambda(hm);
        for (Map.Entry<String, Integer> en : newHm1.entrySet()) {
            System.out.println("Key = " + en.getKey() + 
                          ", Value = " + en.getValue());
        }
        System.out.println();
        Map<String, Integer> newHm2 = sortedHashMapUsingStream(hm);
        for (Map.Entry<String, Integer> en : newHm2.entrySet()) {
            System.out.println("Key = " + en.getKey() + 
                          ", Value = " + en.getValue());
        }
	}
	static HashMap<String, Integer> sortedHashMap(HashMap<String, Integer> hm){
	    List<Map.Entry<String, Integer>> l = new LinkedList<Map.Entry<String, Integer>>(hm.entrySet());
	    
	    Collections.sort(l, new Comparator<Map.Entry<String, Integer>>(){
	        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2){
	            return o1.getValue().compareTo(o2.getValue());
	        }
	    });
	    
	    HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
	    for(Map.Entry<String, Integer> a: l){
	        temp.put(a.getKey(), a.getValue());
	    } 
	    return temp;
	}
	
	static HashMap<String, Integer> sortedHashMapUsingLambda(HashMap<String, Integer> hm){
	    List<Map.Entry<String, Integer>> l = new LinkedList<>(hm.entrySet());
	    
	    l.sort((i1, i2) -> i1.getValue().compareTo(i2.getValue()));
	    
	    HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
	    for(Map.Entry<String, Integer> a: l){
	        temp.put(a.getKey(), a.getValue());
	    } 
	    return temp;
	}
	
	static HashMap<String, Integer> sortedHashMapUsingStream(HashMap<String, Integer> hm){
	    
	    HashMap<String, Integer> temp = hm.entrySet().stream()
	                                    .sorted((i1, i2) -> i1.getValue().compareTo(i2.getValue()))
	                                    .collect(Collectors.toMap(
	                                        Map.Entry::getKey,
	                                        Map.Entry::getValue,
	                                        (e1, e2) -> e1, LinkedHashMap::new));
		hm.entrySet().stream().sorted((i1, i2) -> i1.getValue().compareTo(i2.getValue())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) ->e1, LinkedHashMap::new));
	    return temp;
	}
}
