package 哈希表;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//Wrong path, not this simple!

public class n_同构字符串 {
    public boolean isIsomorphic(String s, String t) {
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
            if(!smap.containsKey(c))
                tmap.put(c,1);
            else {
                tmap.put(c,tmap.get(c)+1);
            }
        }

        ArrayList<Integer> sList = new ArrayList<>(smap.values());
        ArrayList<Integer> tList = new ArrayList<>(tmap.values());

        for (Integer num: sList) {
            if(!tList.contains(num))
                return false;
            else
                tList.remove(num);
        }
        return true;
    }

    public static void main(String[] args) {
        n_同构字符串 同构字符串 = new n_同构字符串();
        同构字符串.isIsomorphic("title", "paper");
    }
}
