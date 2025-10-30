package 滑动窗口;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 找字符串中所有字母异构词 {


    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] cntP = new int[26]; // 统计 p 的每种字母的出现次数
        int[] cntS = new int[26]; // 统计 s 的长为 p.length() 的子串 s' 的每种字母的出现次数
        for (char c : p.toCharArray()) {
            cntP[c - 'a']++; // 统计 p 的字母
        }
        for (int right = 0; right < s.length(); right++) {
            cntS[s.charAt(right) - 'a']++; // 右端点字母进入窗口
            int left = right - p.length() + 1;
            if (left < 0) { // 窗口长度不足 p.length()
                continue;
            }
            if (Arrays.equals(cntS, cntP)) { // s' 和 p 的每种字母的出现次数都相同
                ans.add(left); // s' 左端点下标加入答案
            }
            cntS[s.charAt(left) - 'a']--; // 左端点字母离开窗口
        }
        return ans;
    }


    public List<Integer> findAnagrams1(String s, String p) {
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
