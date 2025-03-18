package 栈;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class 简化路径 {

    /**
     * 对于路径的模式，可采用String.split("/")来简化处理
     * 不要用单个字符
     */

    class Solution {
        public String simplifyPath(String path) {
            Stack<String> stack = new Stack<>();
            String[] segments = path.split("/");

            for (String segment : segments) {
                if (segment.isEmpty() || segment.equals(".")) {
                    continue; // Skip empty segments and single "."
                }
                if (segment.equals("..")) {
                    if (!stack.isEmpty()) {
                        stack.pop(); // Move up to the parent directory
                    }
                } else {
                    stack.push(segment); // Valid directory name
                }
            }

            StringBuilder result = new StringBuilder();
            for (String dir : stack) {
                result.append("/").append(dir);
            }

            // Return root if stack is empty
            return result.length() > 0 ? result.toString() : "/";
        }
    }



    /**
     * class Solution {
     *     public String simplifyPath(String path) {
     *         Stack<Character> stack = new Stack<>();
     *         int start = 0;;
     *         for(start=0;start<path.length();start++){
     *             if(path.charAt(start) == '/') break;
     *         }
     *         stack.push('/');
     *         for(int i=start+1;i<path.length()-1;i++){
     *             Character c = path.charAt(i);
     *             if(c == '.'){
     *                 i++;
     *                 if(i == path.length())
     *                     continue;
     *                 if(path.charAt(i) == '/'){
     *                     continue;
     *                 }
     *                 else {
     *                     i++;
     *                     if(i == path.length() || path.charAt(i) == '/'){
     *                         if(stack.size() != 1)
     *                             stack.pop();
     *                         while(stack.size() != 1 && stack.peek() != '/'){
     *                             stack.pop();
     *                         }
     *                         continue;
     *                     }
     *                     else{
     *                         for(int j=0;j<3;j++){
     *                             stack.push('.');
     *                         }
     *                         while(path.charAt(++i) == '.' && i<path.length() ){
     *                             stack.push('.');
     *                         }
     *                         stack.push(path.charAt(i));
     *                     }
     *                 }
     *             }
     *             else if(c == '/' && stack.peek() == '/')
     *                 continue;
     *             else
     *                 stack.push(c);
     *         }
     *         if(path.charAt(path.length()-1) != '/')
     *             stack.push(path.charAt(path.length()-1));
     *         if(stack.peek() == '/' && stack.size() != 1) stack.pop();
     *         StringBuilder sb = new StringBuilder();
     *         while(!stack.isEmpty()){
     *             sb.append(stack.pop().toString());
     *         }
     *         return sb.reverse().toString();
     *
     *     }
     * }
     */
}
