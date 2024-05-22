package 二叉树;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DFS: 用队列
 *  DFS(){
 *      node = queue.pop(x)
 *      queue.push(node.left)
 *      queue.push(node.right)
 *  }
 *
 * 这一题不止是DFS，还要将每层的分别出来，可以对每层进队的节点进行计数，从而在之后出队正确数量
 *
 *      int size = queue.size();
 *      loop (size){
 *          DFS();
 *      }
 */

public class 层序遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> lists = new ArrayList<>();
        traverse(root, 0, map);
        for (int i = 0; map.containsKey(i); i++) {
            lists.add(map.get(i));
        }
        return lists;
    }

    public void traverse(TreeNode node, int layer, HashMap<Integer, List<Integer>> map){
        if (node == null)
            return;

        List<Integer> list;

        if (!map.containsKey(layer)){
            list = new ArrayList<>();
        }
        else {
            list = map.get(layer);
        }

        list.add(node.val);
        map.put(layer, list);

        traverse(node.left, layer+1, map);
        traverse(node.right, layer+1, map);
    }
}
