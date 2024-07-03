package String;

import java.util.HashMap;

public class JsonStringToHashMap {
    public static void main(String[] args){
        String json = "{\"name\": \"John\", \"age\": 30, \"city\": \"New York\"}";
        System.out.println(convertJsonStringToHashMap(json));
    }

    private static HashMap<String, String> convertJsonStringToHashMap(String json) {
        HashMap<String, String> map = new HashMap<>();
        String[] arr = json.replaceAll("[{}]", "").split(",");
        for(String s: arr){
            String[] sr = s.split(":");
            String key = sr[0].trim().replaceAll("\"", "");
            String value = sr[1].trim().replaceAll("\"", "");
            map.put(key, value);
        }
        return map;
    }
}
