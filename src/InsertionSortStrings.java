import java.util.Scanner;

public class InsertionSortStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of words:");
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] words = new String[n];
        
        System.out.println("Enter the words:");
        for (int i = 0; i < n; i++) {
            words[i] = scanner.nextLine();
        }

        for (int i = 1; i < words.length; i++) {
            String key = words[i];
            int j = i - 1;
            while (j >= 0 && words[j].compareTo(key) > 0) {
                words[j + 1] = words[j];
                j--;
            }
            words[j + 1] = key;
        }

        System.out.println("Sorted list of words:");
        for (String word : words) {
            System.out.println(word);
        }
    }
}
