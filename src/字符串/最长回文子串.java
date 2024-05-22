package 字符串;

public class 最长回文子串 {

    class Solution {
        public String longestPalindrome(String s) {
            int n=s.length();
            int count=0, cur_count=0;
            String record="", cur_record;
            int left, right;
            for(int i=1;i<n;i++){
                if(s.charAt(i-1)==s.charAt(i)){
                    cur_record = ""+s.charAt(i-1)+s.charAt(i);
                    if(i-2>=0 && i+1<n) {
                        left = i - 2;
                        right = i + 1;
                    }
                    else
                        continue;
                }
                else if(s.charAt(i-1)==s.charAt(i+1) && i+1<n) {
                    cur_record = String.valueOf(s.charAt(i-1) + s.charAt(i) + s.charAt(i+1));
                    if(i-2>=0 && i+2<n) {
                        left = i - 2;
                        right = i + 2;
                    }
                    else
                        continue;
                }
                else
                    continue;
                char c_left=s.charAt(left);
                char c_right=s.charAt(right);
                while (c_left==c_right && left >=0 && right<n){
                    cur_count++;
                    cur_record = s.charAt(left) + cur_record + s.charAt(right);
                    left--;
                    right++;
                }
                if(count<cur_count){
                    record = cur_record;
                    count = cur_count;
                }
            }
            return record;
        }
    }
}
