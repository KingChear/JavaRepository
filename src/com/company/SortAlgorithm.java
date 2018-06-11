package com.company;

public class SortAlgorithm {

    private static SortAlgorithm instance = new SortAlgorithm();

    private SortAlgorithm() {

    }

    public static SortAlgorithm getInstance() {
        return instance;
    }

    /**
     * 冒泡排序
     *
     * @param array
     */
    public void bubbleSort(int[] array) {
        int swapTemp = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swapTemp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = swapTemp;
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    /**
     * 选择排序
     *
     * @param array
     */
    public void selectSort(int[] array) {
        int index = 0;
        int swapTemp = 0;
        for (int i = 0; i < array.length - 1; i++) {
            index = i;
            for (int j = i; j < array.length; j++) {
                if (array[index] > array[j]) {
                    index = j;
                }
            }
            swapTemp = array[index];
            array[index] = array[i];
            array[i] = swapTemp;

        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    /**
     * 插入排序
     *
     * @param array
     */
    public void insertSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i] < array[j]) {
                    int k = i;
                    int sortNum = array[i];
                    while (k >= j) {
                        array[k] = array[k - 1];
                        k--;
                    }
                    array[j] = sortNum;
                    break;
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    /**
     * 归并排序
     *
     * @param array
     * @param left
     * @param right
     */
    public void mergeSort(int[] array, int left, int right) {

        // 分配一个与原数组相同大小的临时数组
        int[] tempArray = new int[array.length];
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);  // 对左序列进行归并排序
            mergeSort(array, mid + 1, right);  // 对右序列进行归并排序
            merge(array, left, mid, right, tempArray);  // 对指定范围的数组进行归并
        }

    }

    /**
     * 归并排序
     * 对数组进行合并
     *
     * @param array
     * @param left
     * @param mid
     * @param right
     * @param tempArray
     */
    private void merge(int[] array, int left, int mid, int right, int[] tempArray) {

        int i = left;  // 左序列指针
        int j = mid + 1;  // 右序列指针
        int t = 0;  // 临时数组指针

        // 将左序列与右序列的元素进行比较，较小的元素放进tempArray当中
        while (i <= mid && j <= right) {
            if (array[i] < array[j]) {
                tempArray[t++] = array[i++];
            } else {
                tempArray[t++] = array[j++];
            }
        }

        // 将左边剩余的元素放进tempArray当中
        while (i <= mid) {
            tempArray[t++] = array[i++];
        }

        // 将右边剩余的元素放进tempArray当中
        while (j <= right) {
            tempArray[t++] = array[j++];
        }

        t = 0;
        // 将tempArray中的元素拷贝到原数组当中
        while (left <= right) {
            array[left++] = tempArray[t++];
        }

    }

    /**
     * 快速排序
     *
     * @param array
     * @param low
     * @param high
     */
    public void quickSort(int[] array, int low, int high) {

        // 递归退出的条件
        if (low > high) {
            return;
        }

        int i = low;  // 左指针
        int j = high;  // 右指针
        int key = array[low];  // 将待排序列的第一个元素设置为基准key

        while (i < j) {
            // 从右往左遍历，如果某个元素小于基准key，则记录其位置
            while (i < j && array[j] >= key) {
                j--;
            }
            // 从左往右遍历，如果某个元素大于基准key，则记录其位置
            while (i < j && array[i] <= key) {
                i++;
            }

            // 交换i位置的元素与j位置的元素
            if (i < j) {
                int swapTemp = array[i];
                array[i] = array[j];
                array[j] = swapTemp;
            }
        }

        // 交换基准位置的元素与i位置的元素
        int swapTemp = array[i];
        array[i] = array[low];
        array[low] = swapTemp;

        quickSort(array, low, i - 1);  // 基准左边进行快排
        quickSort(array, i + 1, high);  // 基准右边进行快排

    }

    /**
     * 希尔排序
     *
     * @param array
     */
    public void shellSort(int[] array) {

        // increment为每次排序的增量，一趟排序排完之后，increment减半，最后一趟排序increment的值为1
        for (int increment = array.length / 2; increment >= 1; increment /= 2) {
            // i与i - increment的值进行比较，采用插入排序，如果满足交换的条件，前面的值覆盖后面的值，最后将i的值放在合适的位置
            for (int i = increment; i < array.length; i++) {
                int temp = array[i];  // 用temp临时保存i位置的值
                int j = i - increment;  // 与之前的第几个增量increment进行比较
                while (j >= 0 && temp < array[j]) {  // 如果i位置的值比前面第几个增量increment的值小的话，那么就发生交换
                    array[j + increment] = array[j];
                    j = j - increment;
                }
                array[j + increment] = temp;  // 找到i的值合适的位置，将i的值放入
            }
        }

    }

}
