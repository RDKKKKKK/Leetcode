package 数组;

public class 最后一个单词长度 {
    public int lengthOfLastWord(String s) {
        int length = s.length();
        int index = length;
        int count = 0;
        for (int i = s.length()-1; s.charAt(i) == ' ' && i>=0; i--) {
            index = i;
        }
        if(index == 0)
            return 0;
        for (int i = index-1; s.charAt(i) != ' ' && i>=0; i--) {
            count++;
        }
        return count;
    }
}
