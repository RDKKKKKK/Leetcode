package Learning;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Iterable_basic {
    /*
        Iterable
          |
        Collection
          |   |
        List  Set
          |
        Queue
          |
         Map
    */

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        // 使用迭代器显式遍历集合
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            Integer number = iterator.next();
            System.out.println(number);
    }
}
}
