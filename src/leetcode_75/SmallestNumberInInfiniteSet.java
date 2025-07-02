package leetcode_75;

import java.util.TreeSet;

public class SmallestNumberInInfiniteSet {
    private TreeSet<Integer> set = new TreeSet<>();
    int min = 1;

    /*
    public SmallestInfiniteSet() {
    }*/

    public int popSmallest() {
        if(set.isEmpty())
            return min++;
        else
            return set.pollFirst();
    }

    public void addBack(int num) {
        if(num < min)
            set.add(num);
    }
}
