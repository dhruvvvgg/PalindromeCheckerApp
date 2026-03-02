import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {

    // ===== UC1: Application Startup =====
    public static void displayAppInfo() {
        System.out.println("==================================");
        System.out.println("Welcome to Palindrome Checker Application");
        System.out.println("Version 1.0");
        System.out.println("==================================");
        System.out.println();
    }

    // ===== UC2: Hardcoded String Palindrome Check =====
    public static void checkHardcodedPalindrome() {
        String word = "madam";

        String reversed = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            reversed += word.charAt(i);
        }

        if (word.equals(reversed)) {
            System.out.println(word + " is a Palindrome.");
        } else {
            System.out.println(word + " is NOT a Palindrome.");
        }
        System.out.println();
    }

    // ===== UC3: Reverse String and Compare =====
    public static void reverseAndCheck(String input) {

        String reversed = "";

        for (int i = input.length() - 1; i >= 0; i--) {
            reversed += input.charAt(i);
        }

        if (input.equals(reversed)) {
            System.out.println(input + " is a Palindrome.");
        } else {
            System.out.println(input + " is NOT a Palindrome.");
        }

        System.out.println();
    }

    // ===== UC4: Character Array + Two Pointer =====
    public static void checkUsingCharArray(String input) {

        char[] characters = input.toCharArray();

        int start = 0;
        int end = characters.length - 1;
        boolean isPalindrome = true;

        while (start < end) {
            if (characters[start] != characters[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        if (isPalindrome) {
            System.out.println(input + " is a Palindrome.");
        } else {
            System.out.println(input + " is NOT a Palindrome.");
        }

        System.out.println();
    }

    // ===== UC5: Stack Based Palindrome Check =====
    public static void checkUsingStack(String input) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        boolean isPalindrome = true;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != stack.pop()) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println(input + " is a Palindrome.");
        } else {
            System.out.println(input + " is NOT a Palindrome.");
        }

        System.out.println();
    }

    // ===== UC6: Queue vs Stack (FIFO vs LIFO) =====
    public static void checkUsingQueueAndStack(String input) {

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            queue.add(input.charAt(i));   // Enqueue (FIFO)
            stack.push(input.charAt(i)); // Push (LIFO)
        }

        boolean isPalindrome = true;

        while (!queue.isEmpty()) {
            char fromQueue = queue.remove(); // Dequeue
            char fromStack = stack.pop();    // Pop

            if (fromQueue != fromStack) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println(input + " is a Palindrome.");
        } else {
            System.out.println(input + " is NOT a Palindrome.");
        }

        System.out.println();
    }

    // ===== UC7: Deque Based Palindrome Check =====
    public static void checkUsingDeque(String input) {

        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            deque.addLast(input.charAt(i)); // Insert at rear
        }

        boolean isPalindrome = true;

        while (deque.size() > 1) {
            char front = deque.removeFirst(); // Remove front
            char rear = deque.removeLast();   // Remove rear

            if (front != rear) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println(input + " is a Palindrome.");
        } else {
            System.out.println(input + " is NOT a Palindrome.");
        }

        System.out.println();
    }

    // ===== Main Method =====
    public static void main(String[] args) {

        displayAppInfo();                   // UC1
        checkHardcodedPalindrome();         // UC2
        reverseAndCheck("racecar");         // UC3
        checkUsingCharArray("level");       // UC4
        checkUsingStack("radar");           // UC5
        checkUsingQueueAndStack("madam");   // UC6
        checkUsingDeque("civic");           // UC7

        System.out.println("Program Ended.");
    }
}