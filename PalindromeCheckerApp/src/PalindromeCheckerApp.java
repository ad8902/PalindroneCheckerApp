import java.util.Scanner;

class PalindromeChecker {

    private String text;

    public PalindromeChecker(String text) {
        this.text = text.replaceAll("\\s+", "").toLowerCase();
    }

    public boolean checkPalindrome() {
        int start = 0;
        int end = text.length() - 1;
        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string to check if it is a palindrome:");
        String input = scanner.nextLine();

        PalindromeChecker checker = new PalindromeChecker(input);
        if (checker.checkPalindrome()) {
            System.out.println("The given string is a palindrome.");
        } else {
            System.out.println("The given string is not a palindrome.");
        }

        scanner.close();
    }
}