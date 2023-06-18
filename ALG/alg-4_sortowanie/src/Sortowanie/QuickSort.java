package Sortowanie;

import java.util.Arrays;

public class QuickSort {
    static int partition(int[] arr, int start, int end) {

        // pivot jako koncowy element
        int pivot = arr[end];

        // pointer for greater element
        int i = (start - 1);

        // dzielenia listy na dwie podlisty odnosnie pivot
        for (int j = start; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                // swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }

        }

        // swap pivot z wiekszym i-elementem
        int temp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = temp;

        // pozycja po ktorej dzielic liste
        return (i + 1);
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            // szukanie pivot,
            int pivot = partition(arr, start, end);

            // lewa strona (mniejsze)
            quickSort(arr, start, pivot - 1);

            // prawa strona (wieksze)
            quickSort(arr, pivot + 1, end);
        }
    }
}
