package 哈希表;

import java.util.HashMap;
import java.util.Map;

// TIPS: 可以直接统计两个字符串的词频，遍历来进行比较，若ransomeNote里的大于magazine则不满足

public class y_赎金信 {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> mzMap = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {
            if(!mzMap.containsKey(magazine.charAt(i)))
                mzMap.put(magazine.charAt(i), 1);
            else
                mzMap.put(magazine.charAt(i), mzMap.get(magazine.charAt(i))+1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            if (!mzMap.containsKey(ransomNote.charAt(i)))
                return false;
            else {
                if(mzMap.get(ransomNote.charAt(i))!=1)
                    mzMap.put(ransomNote.charAt(i),mzMap.get(ransomNote.charAt(i))-1);
                else
                    mzMap.remove(ransomNote.charAt(i));
            }
        }
        return true;
    }
}
