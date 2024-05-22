package 二叉树;

public class 有序数组转二叉搜索树 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return findMid(nums, 0, nums.length-1);
    }

    public TreeNode findMid(int[] nums, int left, int right){
        if (left > right)
            return null;

        int mid = (left+right)>>>1;

        TreeNode node = new TreeNode(nums[mid]);

        node.left=findMid(nums, left, mid-1);
        node.right=findMid(nums, mid+1, right);

        return node;
    }
}
