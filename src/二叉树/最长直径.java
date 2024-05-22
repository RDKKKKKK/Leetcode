package 二叉树;

class 最大直径 {

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        findMax(root);
        return max;
    }

    public int findMax(TreeNode node){

        if (node == null)
            return 0;

        int left = findMax(node.left);
        int right = findMax(node.right);

        max = Math.max(max, left + right);

        return Math.max(left, right) + 1;
    }
}

