package 字符串;

//TODO *split()*  s.split("x") 若存在连续的xx，则拆分出空串

import java.util.Stack;

public class 翻转字符串里的单词 {
    class Solution {
        public String reverseWords(String s) {
            Stack<String> stack = new Stack<>();
            String[] words = s.split(" ");
            for (int i = 0; i < words.length; i++) {
                if(words[i]!="") //TODO * ""和null不同 *  null指的是没有指向对象
                    stack.push(words[i]);
            }
            StringBuffer stringBuffer=new StringBuffer();
            while(!stack.isEmpty()){
                stringBuffer.append(stack.pop());
                if(!stack.isEmpty())
                    stringBuffer.append(" ");
            }
            return stringBuffer.toString();
        }
    }
}
