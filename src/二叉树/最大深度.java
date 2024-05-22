package 二叉树;


/*
    可以更简洁如下
 */

public class 最大深度 {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return Math.max(leftHeight,rightHeight)+1;
    }


    /*
    public int maxDepth(TreeNode root) {
        return findMax(root, 0);
    }

    public int findMax(TreeNode node, int cur_max){
        if (node == null)
            return cur_max;
        return Math.max(findMax(node.left, cur_max+1), findMax(node.right, cur_max+1));
    }*/
}
