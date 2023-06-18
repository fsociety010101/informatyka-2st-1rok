import java.util.Arrays;

import static Sortowanie.GenerateRandomArray.generateRandomArray;
import static Sortowanie.BubbleSort.bubbleSort;
import static Sortowanie.CombSort.combSort;
import static Sortowanie.QuickSort.quickSort;
import static Sortowanie.RadixSort.radixSort;


public class Main {

    public static void main(String[] args) {

        // generowanie tablicy
        int[] arr = generateRandomArray(5000, 0, 1000);

        // bubble sort
        long millisActualTime = System.currentTimeMillis();
        int[] arr_cpy = arr;
        bubbleSort(arr_cpy);
        long executionTime = System.currentTimeMillis() - millisActualTime;
        System.out.println("Bubble sort: " + Arrays.toString(arr_cpy));
        System.out.println("Execution time: " + executionTime + '\n');

        // comb sort
        millisActualTime = System.currentTimeMillis();
        arr_cpy = arr;
        combSort(arr_cpy);
        executionTime = System.currentTimeMillis() - millisActualTime;
        System.out.println("Comb sort: " + Arrays.toString(arr_cpy));
        System.out.println("Execution time: " + executionTime + '\n');

        // quick sort
        millisActualTime = System.currentTimeMillis();
        arr_cpy = arr;
        quickSort(arr_cpy, 0, 9);
        executionTime = System.currentTimeMillis() - millisActualTime;
        System.out.println("Quick sort: " + Arrays.toString(arr_cpy));
        System.out.println("Execution time: " + executionTime + '\n');

        // radix sort
        millisActualTime = System.currentTimeMillis();
        arr_cpy = arr;
        radixSort(arr_cpy);
        executionTime = System.currentTimeMillis() - millisActualTime;
        System.out.println("Radix sort: " + Arrays.toString(arr_cpy));
        System.out.println("Execution time: " + executionTime + '\n');

        // radix sort, test z zestawu
        millisActualTime = System.currentTimeMillis();
        int[] arr_radix = {132, 234, 564, 353, 311, 253, 711, 456, 845, 312};
        radixSort(arr_radix);
        executionTime = System.currentTimeMillis() - millisActualTime;
        System.out.println("Radix sort z zestawu: " + Arrays.toString(arr_radix));
        System.out.println("Execution time: " + executionTime + '\n');

    }
}