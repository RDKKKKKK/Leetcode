package 哈希表;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 字母异位词分组 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs){
            int[] alphabet = new int[26];
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                int index = c - 'a';
                alphabet[index]++;
            }
            StringBuilder stringBuffer = new StringBuilder();
            for (int i = 0; i < alphabet.length; i++) {
                stringBuffer.append(alphabet[i]);
                stringBuffer.append(",");  // 123可能是1 2 3 也可能是1 23
            }
            String s = stringBuffer.toString();
            if (map.containsKey(s)){
                map.get(s).add(str);
            }
            else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(s, list);
            }
        }
        return new ArrayList<>(map.values());
    }
}


/*
public class 字母异位词分组 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Character, Integer> map = new HashMap<>();
        boolean group =false;
        List<List<String>> res = new ArrayList<>();
        for (String word : strs){
            List<String> resStr = new ArrayList<>();
            resStr.add(word);
            for (int i = 0; i < word.length(); i++) {
                map.put(word.charAt(i), 1);
            }

                if (!map.containsKey(word.charAt(i))){
                    group = false;
                    res.add(resStr);
                    map.clear();
                    break;
                }
            }

            res.add(word);
}*/
