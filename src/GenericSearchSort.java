import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenericSearchSort {

    public static <T extends Comparable<T>> void bubbleSort(List<T> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    Collections.swap(list, j, j + 1);
                }
            }
        }
    }

    public static <T extends Comparable<T>> int binarySearch(List<T> list, T key) {
        int low = 0, high = list.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            T midValue = list.get(mid);
            int comparison = key.compareTo(midValue);
            if (comparison == 0) {
                return mid;
            } else if (comparison < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        Collections.addAll(numbers, 5, 3, 8, 6, 2, 7, 4, 1);

        System.out.println("Original List: " + numbers);
        bubbleSort(numbers);
        System.out.println("Sorted List: " + numbers);

        int key = 6;
        int index = binarySearch(numbers, key);
        System.out.println("Element " + key + (index >= 0 ? " found at index " + index : " not found"));

        List<String> words = new ArrayList<>();
        Collections.addAll(words, "apple", "orange", "banana", "grape");

        System.out.println("Original List: " + words);
        bubbleSort(words);
        System.out.println("Sorted List: " + words);

        String searchWord = "banana";
        int wordIndex = binarySearch(words, searchWord);
        System.out.println("Element " + searchWord + (wordIndex >= 0 ? " found at index " + wordIndex : " not found"));
    }
}

