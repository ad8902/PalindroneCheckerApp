import java.util.Scanner;
import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;

interface PalindromeStrategy {
    boolean isPalindrome(String text);
}

class IterativeStrategy implements PalindromeStrategy {

    public boolean isPalindrome(String text) {
        text = text.replaceAll("\\s+", "").toLowerCase();
        int start = 0;
        int end = text.length() - 1;
        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}

class StackStrategy implements PalindromeStrategy {

    public boolean isPalindrome(String text) {
        text = text.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char c : text.toCharArray()) stack.push(c);
        for (char c : text.toCharArray()) if (stack.pop() != c) return false;
        return true;
    }
}

class DequeStrategy implements PalindromeStrategy {

    public boolean isPalindrome(String text) {
        text = text.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : text.toCharArray()) deque.addLast(c);
        while (deque.size() > 1) if (deque.removeFirst() != deque.removeLast()) return false;
        return true;
    }
}

public class PalindromeCheckerApp {

    public static void measurePerformance(String input, String name, PalindromeStrategy strategy) {
        long startTime = System.nanoTime();
        strategy.isPalindrome(input);
        long endTime = System.nanoTime();
        System.out.println(name + " execution time: " + (endTime - startTime) + " ns");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string to test palindrome performance:");
        String input = scanner.nextLine();

        measurePerformance(input, "Iterative Strategy", new IterativeStrategy());
        measurePerformance(input, "Stack Strategy", new StackStrategy());
        measurePerformance(input, "Deque Strategy", new DequeStrategy());

        scanner.close();
    }
}