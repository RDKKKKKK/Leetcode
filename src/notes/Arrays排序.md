```java
//基本类型数组排序
int[] arr = {5, 2, 9, 1, 5, 6};
Arrays.sort(arr);  // 升序排序：arr = [1, 2, 5, 5, 6, 9]

//对象数组排序（按自然顺序）
String[] names = {"John", "Alex", "Emily", "Chris"};
Arrays.sort(names);  // 按字母升序排序

//自定义排序规则（通过 Comparator）
//按字符串长度排序：
Arrays.sort(names, (a, b) -> a.length() - b.length());

//对二维数组排序
Arrays.sort(intervals, (a, b) -> a[1] - b[1]);  // 按结束时间升序排序
``