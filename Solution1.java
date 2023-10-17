import java.util.Scanner;

import java.util.Arrays;

public class Solution1 {
    public static void main(String[] args) {
        countSwaps();
    }

    public static void countSwaps() {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] elements = new int[size];
        for (int i = 0; i < size; i++) {
            elements[i] = scanner.nextInt();
        }
        System.out.println(calculateSwaps(elements, size));
        scanner.close();
    }

    public static int calculateSwaps(int[] array, int length) {
        int countOfZeros = 0;
        int swapsCount = 0;

        // Count the number of 0s
        for (int element : array) {
            if (element == 0) {
                countOfZeros++;
            }
        }

        // Count the number of 1s in the first countOfZeros elements
        for (int i = 0; i < countOfZeros; i++) {
            if (array[i] == 1) {
                swapsCount++;
            }
        }

        return swapsCount;
    }
}
