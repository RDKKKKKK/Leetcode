package 二叉树;

public class 轴对称 {
    public boolean isSymmetric(TreeNode root) {
        return match(root.left, root.right);
    }

    public boolean match(TreeNode left, TreeNode right){
        if (right == null && left == null)
            return true;
        else if (left == null || right == null)
            return false;
        else if (left.val != right.val)
            return false;
        else
            return match(left.left,right.right) && match(left.right, right.left);
    }
}
