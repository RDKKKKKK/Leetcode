package 二叉树;

public class 验证二叉搜索树 {
    /*
    二叉搜索树的中序遍历是一个递增序列
     */
    TreeNode max;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        // 左
        boolean left = isValidBST(root.left);

        // 中
        if (max != null && root.val <= max.val)
            return false;
        else
            max = root;

        // 右
        boolean right = isValidBST(root.right);
        return right;
    }

}
