package leetcode_75;

//二分查找 注意边界处理
public class GuessNumberHigherOrLower_374 {
    public int guess(int i){return 0;}

    public int guessNumber(int n) {
        int left = 1, right = n;
        while (left<=right){
            int mid = left + (right-left)/2;
            if (guess(mid) == 1) left = mid+1;
            else if (guess(mid) == -1) right = mid;
            else return mid;
        }

        return -1;
    }
}
