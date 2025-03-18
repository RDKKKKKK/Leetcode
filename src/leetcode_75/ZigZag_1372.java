package leetcode_75;

import 二叉树.TreeNode;

public class ZigZag_1372 {

    int max = 0;

    public int longestZigZag(TreeNode root) {
        traverse(root.left, true, 0);
        traverse(root.right, false, 0);
        return max;
    }

    public void traverse(TreeNode node, Boolean isLeft, int length){
        if (node == null) return;

        length++;
        max = Math.max(max, length);

        if (isLeft){
            traverse(node.right, false, length);
            traverse(node.left, true, 0);
        }
        else {
            traverse(node.right, false, 0);
            traverse(node.left, true, length);
        }
    }

}
