package 二叉树;

import java.util.*;

/**
 * DFS：用栈（递归本质）
 *
 * BFS: 用队列
 *  BFS(){
 *      node = queue.pop(x)
 *      queue.push(node.left)
 *      queue.push(node.right)
 *  }
 *
 * 这一题不止是BFS，还要将每层的分别出来，可以对每层进队的节点进行计数，从而在之后出队正确数量
 *      while(queue not empty){
 *        int size = queue.size();
 *        loop (size){
 *          BFS();
 *        }
 *      }
 */



public class 层序遍历 {

    public List<List<Integer>> levelOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        if (root != null)
            queue.add(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < queue.size(); i++) {
                TreeNode cur = queue.poll();
                list.add(cur.val);

                queue.add(cur.left);
                queue.add(cur.right);
            }

            res.add(list);
        }

        return res;

    }




    public List<List<Integer>> levelOrder1(TreeNode root) {
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
