package 双指针;

public class 盛水最多的容器 {
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
