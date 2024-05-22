package 二分查找;

/**
 * 不用两次二分，直接将不同的行拼接上去，拼接可利用%直接获取，不用实际实现
 */


public class 搜索二维矩阵 {

    //TODO 二分查找边界细节处理 wrong
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean ans = false;

        // find row
        int up = 0, down = m-1, mid = 0;
        while (up != down){
            mid = (down-up)>>>2 + up;
            if (mid == 0 && matrix[mid][n-1] >= target){
                ans = true;
                break;
            }
            else if (matrix[mid][n-1] >= target && matrix[mid-1][n-1] <= target){
                ans = true;
                break;
            }
            else if (matrix[mid][n-1] < target)
                up = mid;
            else if (matrix[mid-1][n-1] > target)
                down = mid;
        }

        if (!ans) return ans;
        ans = false;

        int left = 0, right = n-1, center;
        while (left != right){
            center = (right-left)>>>2 + left;
            if (matrix[mid][center] == target){
                ans = true;
                break;
            }
            else if (matrix[mid][center] > target)
                right = mid;
            else
                left = mid;
        }

        return ans;
    }
}
