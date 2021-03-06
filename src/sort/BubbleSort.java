package sort;

import java.util.Arrays;

public class BubbleSort {

    private static int[] bubbleSort(int[] arr) {
        boolean needIteration = true;

        while (needIteration) {
            needIteration = false;

            for (int i = 1; i < arr.length; i++) {
                if (arr[i - 1] > arr[i]) {
                    swap(arr, i - 1, i);
                    needIteration = true;
                }
            }
        }
        return arr;
    }

    private static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    public static void main(String[] args) {
        int[] arrNumber = {3, 5, 2};
        System.out.println("Source array:" + Arrays.toString(arrNumber));

        int[] sortedArr = bubbleSort(arrNumber);
        System.out.println("Sorted array:" + Arrays.toString(sortedArr));
    }
}
