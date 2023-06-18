package Sortowanie;

import java.util.Arrays;

public class CombSort {
    static int updateGap(int gap) {
        gap = (gap * 10) / 13;
        if (gap < 1)
            return 1;
        return gap;
    }

    public static void combSort(int[] arr) {

        int gap = arr.length;
        boolean swapped = true;

        // sortuj dopoki gap > 1 i gdy podczas ostatniej iteracji liczby byly zamieniane
        while (gap != 1 || swapped) {
            gap = updateGap(gap);
            swapped = false;

            // porownanie elementow z obecnym gap
            for (int i = 0; i < arr.length - gap; i++) {
                // swap jezeli wieksze
                if (arr[i] > arr[i + gap]) {
                    int temp = arr[i];
                    arr[i] = arr[i + gap];
                    arr[i + gap] = temp;

                    swapped = true;
                }
            }
        }
    }
}
