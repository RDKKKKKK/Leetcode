package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 右视图 {
    public List<Integer> rightSideView(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        queue.offer(root);

        while (queue.size()!=0){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left!=null)
                    queue.offer(node.left);
                if (node.right!=null)
                    queue.offer(node.right);
                if (i == size-1)
                    res.add(node.val);
            }
        }

        return res;

    }
    /*
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        traverse(root.left, root.right, list);
        return list;
    }

    public void traverse(TreeNode leftNode, TreeNode rightNode, List<Integer> list){

        if (leftNode == null && rightNode == null)
            return;

        else if (rightNode != null){
            list.add(rightNode.val);
            traverse(rightNode.left, rightNode.right, list);
        }
        else {
            list.add(leftNode.val);
            traverse(leftNode.left, leftNode.right, list);
        }
    }*/
}
