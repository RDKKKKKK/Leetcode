package 二叉树;

public class 完全二叉树的节点个数 {
    public int countNodes(TreeNode root) {
        TreeNode cur = root;
        int level = 0;

        while(cur != null){
            level++;
            cur = cur.left;
        }

        if (root == null) return 0;

        return findNull(root, 1, level);
    }

    public int findNull(TreeNode node, int countLevel, int level){
        if (countLevel == level && node == null) return 0;

        if (countLevel == level && node != null) return 1;

        return 1 + findNull(node.left, countLevel+1, level) + findNull(node.right, countLevel+1, level);
    }
}
