package 二叉树;

public class 二叉树的最长交错路径 {

    /**
     * 两个递归可以整合：
     * 到每一节点一边接着计数，另一边起新的路
     *
     */
    int max = 0;

    public int longestZigZag(TreeNode root) {
        max = Math.max(zigZag(true, root.left, 0), zigZag(false, root.right, 0));
        doZigZag(true, root.left);
        doZigZag(false, root.right);
        return max;
    }

    public void doZigZag(boolean isLeft, TreeNode node){
        if (node == null) return;
        int cur = 0;

        if (isLeft) cur = zigZag(true, node.left, 0);
        else cur = zigZag(false, node.right, 0);

        if (cur > max) max = cur;
        doZigZag(true, node.left);
        doZigZag(false, node.right);
    }

    public int zigZag(boolean isLeft, TreeNode node, int length){
        if (node == null) return length;
        if (isLeft) return zigZag(false, node.right, length+1);
        else return zigZag(true, node.left, length+1);
    }
}
