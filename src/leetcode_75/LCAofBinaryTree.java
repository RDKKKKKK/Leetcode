package leetcode_75;

import 二叉树.TreeNode;

public class LCAofBinaryTree {

    TreeNode res = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findKey(root, p.val, p, q);
        findKey(root, q.val, p, q);

        return res;
    }

    public boolean findKey(TreeNode node, int key, TreeNode p, TreeNode q){
        if(node.val == key){
            return true;
        }

        if (((findKey(node.left, p.val, p, q)) && (findKey(node.right, q.val, p, q)))||(findKey(node.left, q.val, p, q) && findKey(node.right, p.val, p, q))){
            res = node;
        }

        return false;
    }

    }
