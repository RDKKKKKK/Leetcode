package 二叉树;

public class 展开为链表 {
    public void flatten(TreeNode root) {
        shift(root);
    }

    public void shift(TreeNode node){
        if (node == null || node.left == null)
            return;

        shift(node.left);

        TreeNode temp = node.right;
        node.right = node.left;
        node.right.right = temp;
        node.left = null;



    }
}
