import java.util.Scanner;

public class PrimeNumbersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the lower bound of the range:");
        int lower = scanner.nextInt();
        System.out.println("Enter the upper bound of the range:");
        int upper = scanner.nextInt();

        System.out.println("Prime numbers in the range:");
        for (int num = lower; num <= upper; num++) {
            if (isPrime(num)) {
                System.out.println(num);
            }
        }
    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
