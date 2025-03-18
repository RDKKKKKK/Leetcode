package 双指针;

public class 盛水最多的容器 {
    /**
     * brute-force：左右两指针各挪一下来计算所有情况
     * 排除多余情况：盛水量只会更小 的指针移动情况排除不考虑
     * 对于左右指针，移动较大的一定不会得到更大的盛水量（短板）
     * 每次移动都可以视为单独的一个新情况，同一种解法处理
     *
     * @param height
     * @return
     */


    public int maxArea(int[] height) {
        int left=0, right=height.length-1;
        int max = 0;
        while (left != right){
            int cur = Math.min(height[left], height[right])*(right-left);
            if (cur>max)
                max=cur;
            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return max;
    }
}
