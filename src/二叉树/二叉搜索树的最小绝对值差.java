package 二叉树;

public class 二叉搜索树的最小绝对值差 {

    /*
    二叉搜索树求值求差等，利用中序遍历有序的特性（e.g. 验证二叉搜索树）
     */

    TreeNode pre=null;
    int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        traverse(root);
        return min;

    }

    public void traverse(TreeNode root){
        if(root == null) return;

        traverse(root.left);

        if( pre != null && Math.abs(root.val - pre.val) < min )
            min = Math.abs(root.val - pre.val);

        pre = root;

        traverse(root.right);
    }
}
