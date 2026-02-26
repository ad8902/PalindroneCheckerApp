import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
public class PalindromeCheckerApp {
    public static void main(String[] args) {
        String word = "level";
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        for (int i = 0; i < word.length(); i++) {
            stack.push(word.charAt(i));
            queue.add(word.charAt(i));
        }

        boolean isPalindrome = true;

        for (int i = 0; i < word.length(); i++) {
            if (!stack.pop().equals(queue.remove())) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println(word + " is a palindrome");
        } else {
            System.out.println(word + " is not a palindrome");
        }
    }
}