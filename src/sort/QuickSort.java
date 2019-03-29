package sort;

import java.util.Arrays;

public class QuickSort {

    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end) return;
        int pivot = (start + end) / 2;
        int left = start;
        int right = end;

        while (left < right) {
            while (arr[left] <= arr[pivot] && left < pivot) {
                left++;
            }

            while (arr[pivot] <= arr[right] && pivot < right) {
                right--;
            }

            if (left < right) {
                swap(arr, left, right);
                if (pivot == left) {
                    pivot = right;
                } else if (pivot == right) {
                    pivot = left;
                }
            }
        }
        quickSort(arr, start, pivot);
        quickSort(arr, pivot + 1, end);
    }

    private static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    private int[] sort(int[] arr) {
        int[] process = arr.clone();
        quickSort(process, 0, process.length - 1);
        return process;
    }

    public static void main(String[] args) {
        int[] arrNumber = {3, 5, 2, 10, 4, 5, 6, 8, 1, 11};
        System.out.println("Source array:" + Arrays.toString(arrNumber));

        System.out.println("Sorted array:" + Arrays.toString(new QuickSort().sort(arrNumber)));
    }
}
