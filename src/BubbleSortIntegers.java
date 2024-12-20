import java.util.Scanner;

public class BubbleSortIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of integers:");
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        
        System.out.println("Enter the integers:");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }

        System.out.println("Sorted list of integers:");
        for (int number : numbers) {
            System.out.println(number);
        }
    }
}
