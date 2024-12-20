import java.util.Scanner;

public class MergeSortStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of strings:");
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] strings = new String[n];

        System.out.println("Enter the strings:");
        for (int i = 0; i < n; i++) {
            strings[i] = scanner.nextLine();
        }

        mergeSort(strings, 0, strings.length - 1);

        System.out.println("Sorted list of strings:");
        for (String str : strings) {
            System.out.println(str);
        }
    }

    public static void mergeSort(String[] array, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(array, low, mid);
            mergeSort(array, mid + 1, high);
            merge(array, low, mid, high);
        }
    }

    public static void merge(String[] array, int low, int mid, int high) {
        int leftSize = mid - low + 1;
        int rightSize = high - mid;

        String[] left = new String[leftSize];
        String[] right = new String[rightSize];

        for (int i = 0; i < leftSize; i++) {
            left[i] = array[low + i];
        }

        for (int i = 0; i < rightSize; i++) {
            right[i] = array[mid + 1 + i];
        }

        int i = 0, j = 0, k = low;

        while (i < leftSize && j < rightSize) {
            if (left[i].compareTo(right[j]) <= 0) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        while (i < leftSize) {
            array[k++] = left[i++];
        }

        while (j < rightSize) {
            array[k++] = right[j++];
        }
    }
}

