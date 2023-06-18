package Sortowanie;

import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int rob;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (arr[j - 1] > arr[j]) {
                    rob = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = rob;
                }
            }
        }
    }
}
