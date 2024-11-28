public class MergeSort {
    public static void mergeSort(int[] arr) {
        int n = arr.length;

        if (n > 1) {
            // Divide the array into two halves
            int mid = n / 2;

            // Left half array
            int[] left = new int[mid];
            for (int i = 0; i < mid; i++) {
                left[i] = arr[i];
            }

            // Right half array
            int[] right = new int[n - mid];
            for (int i = mid; i < n; i++) {
                right[i - mid] = arr[i];
            }

            // Sort the left and right halves
            mergeSort(left);
            mergeSort(right);

            // Merge the sorted left and right halves
            merge(arr, left, right, mid, n - mid);
        }
    }

    public static void merge(int[] arr, int[] left, int[] right, int leftSize, int rightSize) {
        int i = 0, j = 0, k = 0;

        // Merge the left and right halves into arr[0..n-1]
        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        // Copy the remaining elements of left[], if there are any
        while (i < leftSize) {
            arr[k++] = left[i++];
        }

        // Copy the remaining elements of right[], if there are any
        while (j < rightSize) {
            arr[k++] = right[j++];
        }
    }

    public static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int[] arr = {12, 11, 13, 5, 6, 7};

        System.out.println("Original array:");
        printArray(arr);

        mergeSort(arr);

        System.out.println("Sorted array:");
        printArray(arr);
    }
}