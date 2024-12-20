import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StringPermutations {
	 public static List<String> getPermutationsIterative(String str) {
	        List<String> permutations = new ArrayList<>();
	        permutations.add("");
	        
	        for (char c : str.toCharArray()) {
	            List<String> current = new ArrayList<>();
	            
	            for (String perm : permutations) {
	                for (int i = 0; i <= perm.length(); i++) {
	                    String newPerm = perm.substring(0, i) + c + perm.substring(i);
	                    current.add(newPerm);
	                }
	            }
	            permutations = current;
	        }
	        //System.out.println(permutations);
	        Collections.sort(permutations);
	        return permutations;
	    }
	 public static List<String> getPermutationsRecursive(String str) {
	        List<String> permutations = new ArrayList<>();
	        generatePermutations("", str, permutations);
	        Collections.sort(permutations);
	        return permutations;
	    }
	    
	    private static void generatePermutations(String prefix, String remaining, List<String> permutations) {
	        int length = remaining.length();
	        
	        if (length == 0) {
	            permutations.add(prefix);
	            return;
	        }
	        
	        for (int i = 0; i < length; i++) {
	            String newPrefix = prefix + remaining.charAt(i);
	            String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);
	            generatePermutations(newPrefix, newRemaining, permutations);
	        }
	    }
	    
	    public static boolean arePermutationsEqual(List<String> list1, List<String> list2) {
	        if (list1.size() != list2.size()) {
	            return false;
	        }
	        
	        for (int i = 0; i < list1.size(); i++) {
	            if (!list1.get(i).equals(list2.get(i))) {
	                return false;
	            }
	        }
	        return true;
	    }

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a string for permutation : ");
		 String input = scanner.nextLine();
		 
		 System.out.println("\nGenerating permutations for: " + input);
         
         List<String> iterativeResult = getPermutationsIterative(input);
         List<String> recursiveResult = getPermutationsRecursive(input);
         
         System.out.println("\nIterative Method Results:");
         System.out.println("Permutations: " + iterativeResult);
         System.out.println("Count: " + iterativeResult.size());
         
         System.out.println("\nRecursive Method Results:");
         System.out.println("Permutations: " + recursiveResult);
         System.out.println("Count: " + recursiveResult.size());
         
         System.out.println("\nBoth methods produced identical results: " + 
                          arePermutationsEqual(iterativeResult, recursiveResult));
		

	}

}
