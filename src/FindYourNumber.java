public class FindYourNumber {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please provide a single argument N .");
            return;
        }

        int N = Integer.parseInt(args[0]);
        int low = 0, high = N - 1;
        System.out.println("Think of a number between 0 and " + (N - 1) + ".");
        guessNumber(low, high);
    }

    public static void guessNumber(int low, int high) {
        if (low == high) {
            System.out.println("Your number is: " + low);
            return;
        }

        int mid = low + (high - low) / 2;
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("Is your number between " + low + " and " + mid + "? (true/false): ");
        boolean isInLowerHalf = scanner.nextBoolean();

        if (isInLowerHalf) {
            guessNumber(low, mid);
        } else {
            guessNumber(mid + 1, high);
        }
    }
}
