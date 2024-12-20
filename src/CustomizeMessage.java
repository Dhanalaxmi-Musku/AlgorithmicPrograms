import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomizeMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the message:");
        String message = scanner.nextLine();

        String firstName = "Dhanalaxmi";
        String fullName = "Musku Dhanalaxmi";
        String contactNumber = "91-1234567890";
        String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        Pattern namePattern = Pattern.compile("<<name>>");
        Matcher nameMatcher = namePattern.matcher(message);
        message = nameMatcher.replaceAll(firstName);

        Pattern fullNamePattern = Pattern.compile("<<full name>>");
        Matcher fullNameMatcher = fullNamePattern.matcher(message);
        message = fullNameMatcher.replaceAll(fullName);

        Pattern contactPattern = Pattern.compile("91-xxxxxxxxxx");
        Matcher contactMatcher = contactPattern.matcher(message);
        message = contactMatcher.replaceAll(contactNumber);

        Pattern datePattern = Pattern.compile("\\d{2}/\\d{2}/\\d{4}");
        Matcher dateMatcher = datePattern.matcher(message);
        message = dateMatcher.replaceAll(currentDate);

        System.out.println("Modified Message:");
        System.out.println(message);
    }
}

