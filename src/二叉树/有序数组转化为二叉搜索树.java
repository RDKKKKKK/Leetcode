package 二叉树;

/*
    类似二分查找来创建节点
    注意区间的定义 以及匹配的终止判断条件
 */

public class 有序数组转化为二叉搜索树 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return traverse(nums, 0, nums.length);
    }

    public TreeNode traverse(int[] nums, int left, int right){
        if (left >= right) return null;

        int mid = left + ((right - left) / 2);
        TreeNode root = new TreeNode(nums[mid]);


        root.left = traverse(nums, left, mid);
        root.right = traverse(nums, mid+1, right);

        return root;
    }
}
