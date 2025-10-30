package Learning;

import java.util.HashSet;

public class String_basic {
    public void basicOperation(){
        StringBuilder sb = new StringBuilder();
        sb.append("hello");
        sb.insert(2, "X"); // "heXllo"
        sb.reverse(); // "ollXeH"
        sb.delete(0,1); //sb.delete(indexStart, indexEnd);
        String result = sb.toString();

        String newStr = result.replace("*", ""); //replace char
        String subStr = newStr.substring(2, 5);  // [2, 5)

        newStr.equals(result);  // true 或 false
        int resl = newStr.compareTo(result);  // 字典顺序比较，返回负数、0 或正数
        String[] segments = newStr.split("/");

        char[] arr = result.toCharArray(); //String和CharArray互转
        arr[0] = 'X';
        String s = new String(arr);

    }
}
