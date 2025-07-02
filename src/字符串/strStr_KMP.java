package 字符串;

public class strStr_KMP {
    public int strStr(String haystack, String needle) {

        //构建next数组 - next[i]=i之前最长相等前后缀的位置 aabaaf next[f] = b 前后aa=aa
        int[] next = new int[needle.length()];
        int j=0;
        for (int i = 1; i < needle.length(); i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)){
                j = next[j-1];
            }
            if (needle.charAt(i) == needle.charAt(j))
                j++;
            next[i] = j;
        }

        //匹配
        int index = 0;
        // 匹配过程
        j = 0; // 重置指针，表示 needle 当前匹配的索引
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1]; // 匹配失败，跳转
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == needle.length()) {
                return i - needle.length() + 1; // 完全匹配，返回起始位置
            }
        }

        return -1;
    }
}
