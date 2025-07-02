package 二叉树;

public class 二叉树的最近公共祖先 {

    /**    越递归必越深，无需记录值比较
     *     分情况讨论：
     *     根据 left 和 right ，可展开为四种情况；
     *     1. 当 left 和 right 同时为空 ：说明 root 的左 / 右子树中都不包含 p,q ，返回 null ；
     *     2. 当 left 和 right 同时不为空 ：说明 p,q 分列在 root 的 异侧 （分别在 左 / 右子树），因此 root 为最近公共祖先，返回 root ；
     *     3. 当 left 为空 ，right 不为空 ：p,q 都不在 root 的左子树中，直接返回 right 。具体可分为两种情况：
     *          p,q 其中一个在 root 的 右子树 中，此时 right 指向 p（假设为 p ）；
     *          p,q 两节点都在 root 的 右子树 中，此时的 right 指向 最近公共祖先节点 ；
     *     4. 当 left 不为空 ， right 为空 ：与情况 3. 同理；
     *
     *     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
     *         if(root == null || root == p || root == q) return root;
     *
     *         TreeNode left = lowestCommonAncestor(root.left, p, q);
     *         TreeNode right = lowestCommonAncestor(root.right, p, q);
     *
     *         if(left == null && right == null) return null; // 1.
     *         if(left == null) return right; // 3.
     *         if(right == null) return left; // 4.
     *         return root; // 2. if(left != null and right != null)
     *     }
     *
     *
     */

    int lowest = 0;
    TreeNode ans = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lowestHelper(root, p, q, 0);
        return ans;
    }

    public void lowestHelper(TreeNode root, TreeNode p, TreeNode q, int height){
        if (root == null) return;

        height++;

        if (findLowestAnces(root, p) && findLowestAnces(root, q) && height > lowest) {
            ans = root;
            lowest = height;
        }

        lowestHelper(root.left, p, q, height);
        lowestHelper(root.right, p, q, height);
    }

    public boolean findLowestAnces(TreeNode treeNode, TreeNode target){
        if (treeNode == null) return false;
        if (treeNode == target) return true;

        return (findLowestAnces(treeNode.left, target) || findLowestAnces(treeNode.right, target));
    }
}
