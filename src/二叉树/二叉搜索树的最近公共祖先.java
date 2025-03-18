package 二叉树;

public class 二叉搜索树的最近公共祖先 {
    /*
    相比不同二叉树，搜索树只需一次递归，找到的额第一个公共祖先（p<LCA<q）即为答案
    不会有别的更深的因为，BST对于两个节点的分叉点一定是唯一的
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
        return root;
    }
}
