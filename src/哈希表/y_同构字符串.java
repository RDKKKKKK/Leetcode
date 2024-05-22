package 哈希表;

import java.util.HashMap;
import java.util.Map;

// 双向映射

public class y_同构字符串 {
    public boolean isIsomorphic(String s, String t){
        return isIsomorphicHelper(s,t) && isIsomorphicHelper(t,s);
    }

    public boolean isIsomorphicHelper(String keyString, String valueString){
        Map<Character, Character> map=new HashMap<>();
        for (int i = 0; i < keyString.length(); i++) {
            Character k = keyString.charAt(i);
            if(map.containsKey(k) && valueString.charAt(i)!=map.get(k))
                return false;
            map.put(keyString.charAt(i), valueString.charAt(i));
        }
        return true;
    }
}
