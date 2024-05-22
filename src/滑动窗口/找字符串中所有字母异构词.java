package 滑动窗口;

import java.util.ArrayList;
import java.util.List;

public class 找字符串中所有字母异构词 {
    public List<Integer> findAnagrams(String s, String p) {
        int sl = s.length(), pl = p.length();

        if (sl < pl) return new ArrayList<>();

        List<Integer> ans = new ArrayList<>();

        int[] count = new int[26];

        for (int i = 0; i < pl; i++) {
            count[p.charAt(i) - 'a']++;
            count[s.charAt(i) - 'a']--;
        }

        int differ = 0;

        for (int i = 0; i < 26; i++) {
            if (count[i] != 0)
                differ++;
        }

        if (differ == 0) ans.add(0);

        for (int i = 0; i < sl - pl; i++) {
            // i to be removed
            if (count[s.charAt(i) - 'a'] == -1) differ--;
            else if (count[s.charAt(i) - 'a'] == 0) differ++;
            count[s.charAt(i) - 'a']++;

            // i + pl to be added
            if (count[s.charAt(i+pl) - 'a'] == 1) differ--;
            else if (count[s.charAt(i+pl) - 'a'] == 0) differ++;
            count[s.charAt(i+pl) - 'a']--;

            if (differ == 0)
                ans.add(i+1);
        }

        return ans;
    }
}
