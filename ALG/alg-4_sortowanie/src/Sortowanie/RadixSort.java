package Sortowanie;

import java.util.Arrays;

public class RadixSort {
    public static void countingSort(int[] arr, int place) {
        int[] output = new int[arr.length];

        int[] count = new int[10];
        Arrays.fill(count, 0);

        // zapisywanie liczb wystapien
        for (int i = 0; i < arr.length; i++)
            count[(arr[i] / place) % 10]++;

        // count[i] zawiera teraz aktualna pozycje liczby w output[]
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[(arr[i] / place) % 10] - 1] = arr[i];
            count[(arr[i] / place) % 10]--;
        }

        // kopiowanie posortowanej tablicy wedlug aktualnej cyfry
        System.arraycopy(output, 0, arr, 0, arr.length);
    }

    public static void radixSort(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }

        for (int place = 1; max / place > 0; place *= 10) {
            countingSort(arr, place);
        }
    }
}
