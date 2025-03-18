package 二叉树;

public class 把二叉搜索树转换为累加树 {
    /*
    根据题意，按 右中左 进行累加
     */

    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }

    public void traverse(TreeNode node){
        if(node == null) return;
        traverse(node.right);
        node.val+=sum;
        sum = node.val;
        traverse(node.left);
    }
}
