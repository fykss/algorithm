package sort;

import java.util.Arrays;

public class SelectionSort {

    private static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
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

        int[] sortedArr = selectionSort(arrNumber);
        System.out.println("Sorted array:" + Arrays.toString(sortedArr));
    }
}
