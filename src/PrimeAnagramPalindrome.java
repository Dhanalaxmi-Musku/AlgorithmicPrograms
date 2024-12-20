import java.util.Scanner;
import java.util.ArrayList;

public class PrimeAnagramPalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the lower bound of the range:");
        int lower = scanner.nextInt();
        System.out.println("Enter the upper bound of the range:");
        int upper = scanner.nextInt();

        ArrayList<Integer> primes = new ArrayList<>();
        System.out.println("Prime numbers that are Palindromes and Anagrams:");

        for (int num = lower; num <= upper; num++) {
            if (isPrime(num)) {
                primes.add(num);
                if (isPalindrome(num)) {
                    System.out.println(num + " (Palindrome)");
                }
            }
        }

        System.out.println("Prime numbers that are Anagrams:");
        for (int i = 0; i < primes.size(); i++) {
            for (int j = i + 1; j < primes.size(); j++) {
                if (areAnagrams(String.valueOf(primes.get(i)), String.valueOf(primes.get(j)))) {
                    System.out.println(primes.get(i) + " and " + primes.get(j) + " (Anagrams)");
                }
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

    public static boolean isPalindrome(int num) {
        String str = String.valueOf(num);
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean areAnagrams(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        java.util.Arrays.sort(arr1);
        java.util.Arrays.sort(arr2);
        return java.util.Arrays.equals(arr1, arr2);
    }
}

