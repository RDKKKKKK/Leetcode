package 二分查找;

public class 猜数字游戏 {

    /**
     *注意边界控制和int越界
     */

    public int guessNumber(int n) {
        int left = 1, right = n;

        //边界控制：通过定义左右开闭分析该边是否可能是答案（闭可能 开不可能）来确定left </<= right 和 left/right ~ mid
        //         nums[mid] > target mid一定不是答案，右闭 右边界会计入计算 mid-1
        //[left, right] 左闭右闭写法 ：left <= right right = mid -1 left = mid + 1
        //[left, right) 左闭右开写法
        while (left < right) { // 循环直至区间左右端点相同
            int mid = left + (right - left) / 2; // 防止计算时溢出
            if (guess(mid) <= 0) {
                right = mid; // 答案在区间 [left, mid] 中
            } else {
                left = mid + 1; // 答案在区间 [mid+1, right] 中
            }
        }
        // 此时有 left == right，区间缩为一个点，即为答案
        return left;
    }

    public int guess(int n){
        return 0; //题给
    }
}
