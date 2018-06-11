package com.company;

public class selectAlgorithm {

    private static selectAlgorithm instance = new selectAlgorithm();

    private selectAlgorithm() {

    }

    public static selectAlgorithm getInstance() {
        return instance;
    }

    /**
     * 基于有序数组的二分查找算法
     * @param array
     * @param number
     * @return
     */
    public int binarySearch(int []array, int number) {
        int index = 0;
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            index = (low + high) / 2;
            if (array[index] == number) {
                return index;
            } else if (array[index] > number) {
                high = index - 1;
            } else if (array[index] < number) {
                low = index + 1;
            }

        }

        return -1;
    }

    /**
     * 数组的顺序查找算法
     * @param array
     * @param number
     * @return
     */
    public int orderSearch(int []array, int number) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                return i;
            }
        }
        return -1;
    }

}
