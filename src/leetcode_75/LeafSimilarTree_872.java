package leetcode_75;

import 二叉树.TreeNode;

public class LeafSimilarTree_872 {
    boolean ready1;
    int val1;
    int val2;
    boolean ready2;
    boolean res = true;

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        traverse(root1, 1, root2);

        return res;
    }

    public void traverse(TreeNode node, int type, TreeNode root2){
        if (node.left == null && node.right == null){
            if(type == 1){
                val1 = node.val;
                ready1 = true;
                while (!ready2){
                    traverse(root2, 2, null);
                }
                if (val1 != val2) res = false;
                ready1 = false;
                ready2 = false;
                return;
            }

            else {
                val2 = node.val;
                ready2 = true;
                return;
            }

        }

        traverse(node.left, type, root2);
        traverse(node.right, type, root2);

    }
}
