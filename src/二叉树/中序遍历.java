package 二叉树;

import java.util.ArrayList;
import java.util.List;

public class 中序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traverse(root, res);
        return res;
    }

    public void traverse(TreeNode node, List<Integer> res){
        if (node == null)
            return;
        traverse(node.left, res);
        res.add(node.val);
        traverse(node.right,res);
    }
}
