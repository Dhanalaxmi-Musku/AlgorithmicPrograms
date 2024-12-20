import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
public class BinarySearch {
	public static void main(String[] args) {
        try {
            String[] words = readWordsFromFile("wordlist.txt");
            Arrays.sort(words);
            
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter word to search: ");
            String searchWord = scanner.nextLine();
            
            int result = binarySearch(words, searchWord);
            
            if (result != -1) {
                System.out.println("Word '" + searchWord + "' found in the list");
            } else {
                System.out.println("Word '" + searchWord + "' not found in the list");
            }
            
            scanner.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    
    private static String[] readWordsFromFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line = reader.readLine();
        reader.close();
        return line.split(",");
    }
    
    private static int binarySearch(String[] arr, String target) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = arr[mid].compareTo(target);
            
            if (comparison == 0) {
                return mid;
            }
            
            if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

}
