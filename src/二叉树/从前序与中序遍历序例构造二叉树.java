package 二叉树;

import java.util.Arrays;
import java.util.HashMap;



public class 从前序与中序遍历序例构造二叉树 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0){
            return null;
        }

        int n = preorder.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        TreeNode root = new TreeNode(preorder[0]);
        int rootIndex = map.get(root.val);

        if (rootIndex == 1 || rootIndex+1 == n) return null;

        root.left = buildTree(Arrays.copyOfRange(preorder, 1, rootIndex), Arrays.copyOfRange(inorder, 0, rootIndex));
        root.right = buildTree(Arrays.copyOfRange(preorder, rootIndex+1, n), Arrays.copyOfRange(inorder, rootIndex+1, n));

        return root;
    }


}
