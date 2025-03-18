package 二叉树;

/**
 * 2024.08.25
 * Max(LeftMax, RightMax)
 */


/*
    可以更简洁如下
    此外，层序遍历也可以解
 */

public class 最大深度 {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
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
