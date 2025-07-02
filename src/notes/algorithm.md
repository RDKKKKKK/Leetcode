
# 算法思想
### 1.贪心算法
买卖股票2 - 拆成小块进行贪心

### 2. 位运算 - "^" 
- 任何数和0做异或运算，结果仍然是原来的数，即 a⊕0=0


- 任何数和其自身做异或运算，结果是0，即 a⊕a=0


- 异或运算满足交换律和结合律，即 a⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b

eg: 只出现一次的数字

### 3. 双指针
分类： 快慢指针 左右指针

使用策略： 

 - 初始化：起点/左右端点

 - 移动：根据问题逻辑判断判断移哪个

 - 边界条件：碰撞或越界

### 4. 排序算法
- 冒泡排序：n^2 比较并交换

- 选择排序：n^2 每个FOR循环找到最小/大的放在最前/后面

- 插入排序：n^2 从前往后 循环将未排序列的每个值插入前面已排序列中适当位置
- 希尔排序：nlogn n=length/2(并不停/2直至1) 划分为n个数组(logn)*各自插入排序(n)
- 归并排序：nlogn 分治思想 递归操作：将两个子序列合成一个排序的序列

```java
public class MergeSort {

    // 主方法，用来排序数组
    public static void mergeSort(int[] array) {
        if (array.length < 2) {
            return; // 如果数组只有一个元素或没有元素，不需要排序
        }
        int mid = array.length / 2; // 找到数组的中间点

        // 分成两个子数组
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];

        // 把数组的元素分别拷贝到两个子数组中
        for (int i = 0; i < mid; i++) {
            left[i] = array[i];
        }
        for (int i = mid; i < array.length; i++) {
            right[i - mid] = array[i];
        }

        // 递归调用mergeSort对两个子数组进行排序
        mergeSort(left);
        mergeSort(right);

        // 合并两个排序好的子数组
        merge(array, left, right);
    }

    // 合并两个有序的子数组到一个大数组中
    private static void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        // 逐个比较两个子数组中的元素，按顺序放入array中
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        // 把剩下的元素复制到array中
        while (i < left.length) {
            array[k++] = left[i++];
        }
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }

    // 测试代码
    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        mergeSort(array);
        System.out.println("排序后的数组: ");
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
```
- 快速排序：nlogn 分治思想 分区获得：小子序列 + 大子序列(选取一个基准数并于所有元素比较，小放前大放后) 两个序列再递归排序
```java
public class QuickSort {

    // 主方法，用于排序数组
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // 找到基准位置
            int pivotIndex = partition(array, low, high);
            // 对基准左侧进行排序
            quickSort(array, low, pivotIndex - 1);
            // 对基准右侧进行排序
            quickSort(array, pivotIndex + 1, high);
        }
    }

    // 分区方法
    private static int partition(int[] array, int low, int high) {
        // 选择最后一个元素作为基准
        int pivot = array[high];
        int i = low - 1; // 指向较小元素的指针

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                // 交换array[i]和array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // 交换基准元素和array[i + 1]，使得基准位于正确的位置
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1; // 返回基准位置
    }

    // 测试代码
    public static void main(String[] args) {
        int[] array = {10, 7, 8, 9, 1, 5};
        quickSort(array, 0, array.length - 1);
        System.out.println("排序后的数组:");
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
```
- 堆排序：最大堆的建堆作用仅仅是将最大值放在根节点上，每次改变根节点树结构都要相应变化，因此通过不断改变根节点来起到整体排序的作用
```java
public class HeapSort {
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    private static void buildMaxHeap(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapify(arr, i);
        }
    }
    
    private static void heapify(int[] arr, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        //记录当前三个节点中的largest值
        if (right < heapLen && arr[right] > arr[largest]) {
            largest = right;
        }
        if (left < heapLen && arr[left] > arr[largest]) {
            largest = left;
        }
        
        //若不在根节点 则替换并更新结构
        if (largest != i) {
            swap(arr, largest, i);
            heapify(arr, largest); //此largest非父节点，而是与父节点交换下来的位置，因此需要对其子结构调整
        }
    }

    /**
     * Heap Sort
     * @param arr
     * @return
     */
    public static int[] heapSort(int[] arr) {
        // index at the end of the heap
        heapLen = arr.length;
        // build MaxHeap
        buildMaxHeap(arr);
        for (int i = arr.length - 1; i > 0; i--) {
            // Move the top of the heap to the tail of the heap in turn
            swap(arr, 0, i);
            heapLen -= 1;
            heapify(arr, 0);
        }
        return arr;
    }
}

```



