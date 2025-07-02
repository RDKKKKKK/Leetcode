package 二叉树;

public class 平衡二叉树 {
    /*
    递归设计理解不是很好
    https://www.programmercarl.com/0110.平衡二叉树.html#算法公开课
     */

    public boolean isBalanced(TreeNode root) {
        if(getHeight(root) == -1) return false;
        else return true;
    }

    public int getHeight(TreeNode node){
        if (node==null) return 0;

        int left = getHeight(node.left);
        int right = getHeight(node.right);

        if(left == -1 || right == -1) return -1;
        if(Math.abs(left - right) > 1) return -1;

        return 1 + Math.max(left, right);
    }
}
