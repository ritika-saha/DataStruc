import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.SimpleDateFormat;
import java.util.Date;

public class q12_CustomizeMessage {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the message
        System.out.println("Enter the message:");
        String message = scanner.nextLine();

        // Replace placeholders using Regex
        String customizedMessage = customizeMessage(message);

        // Output the modified message
        System.out.println("Modified Message:");
        System.out.println(customizedMessage);
        scanner.close();
    }

    private static String customizeMessage(String message) {
        // Replace <<name>> by first name of the user
        String nameRegex = "<<name>>";
        String firstName = "Ritika"; // Replace with the actual first name
        message = message.replaceAll(nameRegex, firstName);

        // Replace <<full name>> by user full name
        String fullNameRegex = "<<full name>>";
        String userFullName = "Ritika Saha"; // Replace with the actual full name
        message = message.replaceAll(fullNameRegex, userFullName);

        // Replace any occurrence of mobile number in the format 91-xxxxxxxxxx by your contact number
        String mobileNumberRegex = "91-\\d{10}";
        String contactNumber = "91-1234567891"; // Replace with the actual contact number
        message = message.replaceAll(mobileNumberRegex, contactNumber);

        // Replace any date in the format XX/XX/XXXX by current date
        String dateRegex = "\\d{2}/\\d{2}/\\d{4}";
        String currentDate = getCurrentDate();
        message = message.replaceAll(dateRegex, currentDate);

        return message;
    }

    private static String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date currentDate = new Date();
        return dateFormat.format(currentDate);
    }
}
