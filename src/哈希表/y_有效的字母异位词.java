package 哈希表;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

//注意要先判断长度是否一致

public class y_有效的字母异位词 {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> smap=new HashMap<>();
        Map<Character, Integer> tmap=new HashMap<>();

        for (Character c:s.toCharArray()){
            if(!smap.containsKey(c))
                smap.put(c,1);
            else {
                smap.put(c,smap.get(c)+1);
            }
        }

        for (Character c:t.toCharArray()){
            if(!tmap.containsKey(c))
                tmap.put(c,1);
            else {
                tmap.put(c,tmap.get(c)+1);
            }
        }

        if (smap.size()!=tmap.size())
            return false;

        for(Map.Entry<Character,Integer> entry : smap.entrySet()){
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (!tmap.containsKey(key))
                return false;
            else if (!Objects.equals(value, tmap.get(key)))
                return false;
        }

        return true;

    }
}
