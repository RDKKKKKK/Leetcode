package Learning;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class ArrayList_basic {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        // 添加元素
        list.add(10);
        list.add(20);
        list.add(1, 15); // 在索引1插入15

        // 获取元素
        int element = list.get(1); // 15

        // 替换元素
        list.set(1, 25); // 将索引1的值替换为25

        // 删除元素
        list.remove(Integer.valueOf(25)); // 删除元素25
        list.remove(0); // 删除索引0的元素

        // 遍历元素
        for (Integer num : list) {
            System.out.println(num);
        }

        String s = "aaa";

        for (char c: s.toCharArray()){

        }

        // 批量操作
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(30);
        list2.add(40);
        list.addAll(list2); // 添加list2的所有元素到list

        // 使用迭代器遍历并删除
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() < 30) {
                iterator.remove(); // 安全删除元素
            }
        }

        // 排序
        Collections.sort(list); // 升序排序

        System.out.println(list); // 输出排序后的list
    }}
