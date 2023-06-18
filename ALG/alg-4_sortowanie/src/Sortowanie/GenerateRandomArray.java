package Sortowanie;

import java.util.Arrays;
import java.util.Random;

public class GenerateRandomArray {
    public static int[] generateRandomArray(int size, int start, int end) {
        Random rd = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(start, end);
        }
        System.out.println("Randomly generated array: " + Arrays.toString(arr) + "\n");
        return arr;
    }
}
