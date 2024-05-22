package Learning;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Map_basic {
    public static void main(String[] args) {

        // general map interface
        Map<String, Integer> map=new HashMap<>();

        map.put("Taylor", 34);
        map.get("Taylor");
        map.remove("Taylor");
        int n = map.size();
        Boolean is_empty = map.isEmpty();

        map.containsKey("T");
        map.containsValue(1);

        Set<String> keys = map.keySet(); // key不可重复，所以返回Set
        Collection<Integer> values = map.values(); //值可重复，所以返回Collection

        for (Map.Entry<String, Integer> entry : map.entrySet()){
            entry.getKey();
            entry.getValue();
        }

        // implementation - HashMap, TreeMap, LinkedHashMap



    }
}

