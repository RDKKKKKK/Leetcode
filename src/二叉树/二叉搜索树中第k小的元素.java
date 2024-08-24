package 二叉树;

public class 二叉搜索树中第k小的元素 {

    /**
     * 二叉搜索树BST是左子树全部小，不是只小于当前节点
     * 因此 中序遍历+BST即可得到递增序列
     *
     *public class Solution {
     *     private int count = 0;
     *     private int result = -1;
     *
     *     public int kthSmallest(TreeNode root, int k) {
     *         inorderTraversal(root, k);
     *         return result;
     *     }
     *
     *     private void inorderTraversal(TreeNode node, int k) {
     *         if (node == null) return;
     *
     *         // Traverse the left subtree
     *         inorderTraversal(node.left, k);
     *
     *         // Process the current node
     *         count++;
     *         if (count == k) {
     *             result = node.val;
     *             return;
     *         }
     *
     *         // Traverse the right subtree
     *         inorderTraversal(node.right, k);
     *     }
     * }
     *
     */

    public int kthSmallest(TreeNode root, int k) {
        int max = 10000;
        int[] res = new int[k];
        res[0] = root.val;
        for (int i = 1; i < k; i++) {
            res[i] = max;
        }
        addToSmallestArr(res, root);
        return res[k-1];
    }

    public void addToSmallestArr(int[] arr, TreeNode node){

        if (node == null) return;

        int n = arr.length;
        int smallest = 100000;

        if (node.left != null) {
            smallest = node.left.val;
            for (int i = 0; i < n; i++) {
                if (smallest < arr[i]) {
                    for (int j = n - 2; j >= i; j--) {
                        arr[j + 1] = arr[j];
                    }
                    arr[i] = smallest;
                    break;
                }
            }
        }

        if (node.right != null) {
            smallest = node.right.val;
            for (int i = 0; i < n; i++) {
                if (smallest < arr[i]) {
                    for (int j = n - 2; j >= i; j--) {
                        arr[j + 1] = arr[j];
                    }
                    arr[i] = smallest;
                    break;
                }
            }
        }

        addToSmallestArr(arr, node.left);
        addToSmallestArr(arr, node.right);
    }
}
