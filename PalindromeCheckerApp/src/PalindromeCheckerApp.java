import java.util.Scanner;
import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;

interface PalindromeStrategy {
    boolean isPalindrome(String text);
}

class StackStrategy implements PalindromeStrategy {

    public boolean isPalindrome(String text) {
        text = text.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char c : text.toCharArray()) {
            stack.push(c);
        }
        for (char c : text.toCharArray()) {
            if (stack.pop() != c) {
                return false;
            }
        }
        return true;
    }
}

class DequeStrategy implements PalindromeStrategy {

    public boolean isPalindrome(String text) {
        text = text.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : text.toCharArray()) {
            deque.addLast(c);
        }
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }
}

class PalindromeService {
    private PalindromeStrategy strategy;

    public PalindromeService(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean checkPalindrome(String text) {
        return strategy.isPalindrome(text);
    }
}

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string to check if it is a palindrome:");
        String input = scanner.nextLine();

        System.out.println("Choose strategy: 1 for Stack, 2 for Deque:");
        int choice = scanner.nextInt();

        PalindromeStrategy strategy = choice == 1 ? new StackStrategy() : new DequeStrategy();
        PalindromeService service = new PalindromeService(strategy);

        if (service.checkPalindrome(input)) {
            System.out.println("The given string is a palindrome.");
        } else {
            System.out.println("The given string is not a palindrome.");
        }

        scanner.close();
    }
}