package 二叉树;

public class 翻转二叉树 {
    public TreeNode invertTree(TreeNode root) {
        TreeNode tmp;

        if (root == null)
            return null;

        tmp = invertTree(root.right);
        root.right = invertTree(root.left);
        root.left = tmp;

        return root;
    }
}
