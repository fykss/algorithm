package sort;

import java.util.Arrays;

public class MergeSort {

    private static void merge(int[] arr, int left, int middle, int right) {

        int size_l = middle - left + 1; // !!!
        int size_r = right - middle;
        int[] leftArr = new int[size_l];
        int[] rightArr = new int[size_r];

        for (int i = 0; i < size_l; i++) {
            leftArr[i] = arr[left + i];
        }

        for (int j = 0; j < size_r; j++) {
            rightArr[j] = arr[middle + 1 + j];
        }

        int i = 0, j = 0; // Initial index of first/second subarray
        int  k = left; // Initial index of merged subarray !!!

        while (i < size_l && j < size_r) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i++];
            } else {
                arr[k] = rightArr[j++];
            }
            k++;
        }

        while (i < size_l) {
            arr[k++] = leftArr[i++];
        }

        while (j < size_r) {
            arr[k++] = rightArr[j++];
        }
    }

    void sort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            sort(arr, left, middle); // Sort for first half from left to middle
            sort(arr, middle + 1, right); // Sort for second half from middle + 1 (because middle used for first half) to right
            merge(arr, left, middle, right);
        }
    }

    public static void main(String[] args) {
        int[] arrNumber = {3, 5, 2, 10, 4, 5, 6, 8, 1, 11};
        System.out.println("Source array:" + Arrays.toString(arrNumber));

        new MergeSort().sort(arrNumber, 0, arrNumber.length - 1);
        System.out.println("Sorted array:" + Arrays.toString(arrNumber));
    }
}
