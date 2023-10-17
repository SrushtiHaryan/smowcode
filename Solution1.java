public class Solution1 {

    static int findMinSwaps(int[] arr) {
        int n = arr.length;

        // Count the number of 1s in the array
        int countOnes = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                countOnes++;
            }
        }

        // Initialize variables for the current window
        int windowOnes = 0;
        int minSwaps = Integer.MAX_VALUE;

        // Calculate the number of 1s in the initial window
        for (int i = 0; i < countOnes; i++) {
            if (arr[i] == 1) {
                windowOnes++;
            }
        }

        // Iterate through the rest of the array
        for (int i = countOnes; i < n; i++) {
            // Update minSwaps with the minimum swaps required to move the window
            minSwaps = Math.min(minSwaps, countOnes - windowOnes);

            // Update the window for the next iteration
            if (arr[i] == 1) {
                windowOnes++;
            }
            if (arr[i - countOnes] == 1) {
                windowOnes--;
            }
        }

        // Return the minimum swaps required
        return minSwaps;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 0, 1, 1, 0, 1, 1, 1, 0};

        int minSwaps = findMinSwaps(arr);
        System.out.println("Minimum Swaps: " + minSwaps);
    }
}
