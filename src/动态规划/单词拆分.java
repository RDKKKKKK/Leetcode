package 动态规划;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 单词拆分 {
    /*
    一段字符可能匹配多个单词，原算法匹配一个就确定状态会错过一些也合法的组合
    substring(j,i) 包前不包后，因此 dp[i] 实际表示i之前的单词的状态
     */

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp =new boolean[301];
        dp[0] = false;
        for (int i = 1; i <= s.length(); i++) {
            dp[i]= false;
            for (int j = i-1; j >= 0; j--) {
                if (wordDictSet.contains(s.substring(j,i)) && dp[j]){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }


        public boolean wordBreak1(String s, List<String> wordDict) {
        boolean[] dp =new boolean[301];
        dp[0] = false;
        int end=0;
        for (int i = 1; i < s.length(); i++) {
            dp[i] = false;
            String word = s.substring(end+1,i);
            for (String dict : wordDict){
                if (dict.equals(word)){
                    end=i;
                    dp[i] = true;
                    break;
                }
            }
            dp[i] = dp[i] && dp[end];
        }
        return dp[s.length()-1];
    }
}
