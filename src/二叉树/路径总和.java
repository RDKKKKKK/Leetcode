package 二叉树;
import java.util.HashMap;
import java.util.Map;

public class 路径总和 {
    /**
     * 前缀和：某一节点到一祖先节点的所有结点值的和为唯一值
     * target = (sum) + (target - sum) 即可得到一条满足条件路径
     * 用HashMap来记录每个前缀和可能路径总数
     *
     */


    public class Solution {
        public int pathSum(TreeNode root, int targetSum) {
            Map<Long, Integer> prefixSumCount = new HashMap<>();
            prefixSumCount.put(0L, 1);  // 初始化前缀和为0的情况
            return backtrack(root, prefixSumCount, 0L, targetSum);
        }

        private int backtrack(TreeNode node, Map<Long, Integer> prefixSumCount, long currSum, int targetSum) {
            if (node == null) {
                return 0;
            }

            // 当前路径和（使用long以避免溢出）
            currSum += node.val;

            // 当前路径数目
            int numPathsToCurr = prefixSumCount.getOrDefault(currSum - targetSum, 0);

            // 更新路径和的计数
            prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0) + 1);

            // 递归左右子树
            int result = numPathsToCurr +
                    backtrack(node.left, prefixSumCount, currSum, targetSum) +
                    backtrack(node.right, prefixSumCount, currSum, targetSum);

            // 回溯时减去当前节点的路径和计数
            prefixSumCount.put(currSum, prefixSumCount.get(currSum) - 1);

            return result;
        }
    }

    /*
    int count = 0;

    public int pathSum(TreeNode root, int targetSum) {
    }

    public void pathHelper(TreeNode root, TreeNode node, int sum, int targetSum){
        if (node == null)
            return;
        sum+=node.val;

        if (sum > targetSum){
            pathHelper(node.left, 0, targetSum);
            pathHelper(node.right, 0 ,targetSum);
        }
        else if (sum < targetSum){
            pathHelper(node.left, sum, targetSum);
            pathHelper(node.right, sum, targetSum);
        }
        else {
            count++;

        }
    }*/
}
