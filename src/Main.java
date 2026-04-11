import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {

    // ===== UC1 =====
    public static void displayAppInfo() {
        System.out.println("==================================");
        System.out.println("Welcome to Palindrome Checker Application");
        System.out.println("Version 1.0");
        System.out.println("==================================\n");
    }

    // ===== UC2 =====
    public static void checkHardcodedPalindrome() {
        String word = "madam";
        String reversed = "";

        for (int i = word.length() - 1; i >= 0; i--) {
            reversed += word.charAt(i);
        }

        System.out.println(word + (word.equals(reversed) ? " is a Palindrome.\n" : " is NOT a Palindrome.\n"));
    }

    // ===== UC3 =====
    public static void reverseAndCheck(String input) {
        String reversed = "";

        for (int i = input.length() - 1; i >= 0; i--) {
            reversed += input.charAt(i);
        }

        System.out.println(input + (input.equals(reversed) ? " is a Palindrome.\n" : " is NOT a Palindrome.\n"));
    }

    // ===== UC4 =====
    public static void checkUsingCharArray(String input) {
        char[] arr = input.toCharArray();
        int start = 0, end = arr.length - 1;
        boolean isPalindrome = true;

        while (start < end) {
            if (arr[start] != arr[end]) {
                isPalindrome = false;
                break;
            }
            start++; end--;
        }

        System.out.println(input + (isPalindrome ? " is a Palindrome.\n" : " is NOT a Palindrome.\n"));
    }

    // ===== UC5 =====
    public static void checkUsingStack(String input) {
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) stack.push(c);

        boolean isPalindrome = true;

        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println(input + (isPalindrome ? " is a Palindrome.\n" : " is NOT a Palindrome.\n"));
    }

    // ===== UC6 =====
    public static void checkUsingQueueAndStack(String input) {
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            queue.add(c);
            stack.push(c);
        }

        boolean isPalindrome = true;

        while (!queue.isEmpty()) {
            if (!queue.remove().equals(stack.pop())) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println(input + (isPalindrome ? " is a Palindrome.\n" : " is NOT a Palindrome.\n"));
    }

    // ===== UC7 =====
    public static void checkUsingDeque(String input) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : input.toCharArray()) deque.addLast(c);

        boolean isPalindrome = true;

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println(input + (isPalindrome ? " is a Palindrome.\n" : " is NOT a Palindrome.\n"));
    }

    // ===== UC8 =====
    static class Node {
        char data;
        Node next;
        Node(char data) { this.data = data; }
    }

    public static Node createLinkedList(String input) {
        Node head = null, tail = null;

        for (char c : input.toCharArray()) {
            Node node = new Node(c);
            if (head == null) head = tail = node;
            else {
                tail.next = node;
                tail = node;
            }
        }
        return head;
    }

    public static Node reverseList(Node head) {
        Node prev = null;
        while (head != null) {
            Node next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void checkUsingLinkedList(String input) {
        Node head = createLinkedList(input);
        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node secondHalf = reverseList(slow);
        Node firstHalf = head;

        boolean isPalindrome = true;

        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                isPalindrome = false;
                break;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        System.out.println(input + (isPalindrome ? " is a Palindrome.\n" : " is NOT a Palindrome.\n"));
    }

    // ===== UC9 =====
    public static boolean recursiveCheck(String input, int start, int end) {
        if (start >= end) return true;
        if (input.charAt(start) != input.charAt(end)) return false;
        return recursiveCheck(input, start + 1, end - 1);
    }

    public static void checkUsingRecursion(String input) {
        boolean isPalindrome = recursiveCheck(input, 0, input.length() - 1);
        System.out.println(input + (isPalindrome ? " is a Palindrome.\n" : " is NOT a Palindrome.\n"));
    }

    // ===== UC10 =====
    public static void checkIgnoringSpacesAndCase(String input) {
        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int start = 0, end = normalized.length() - 1;
        boolean isPalindrome = true;

        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                isPalindrome = false;
                break;
            }
            start++; end--;
        }

        System.out.println(input + (isPalindrome ? " is a Palindrome (ignoring spaces & case).\n"
                : " is NOT a Palindrome (ignoring spaces & case).\n"));
    }

    // ===== UC11 =====
    static class PalindromeChecker {
        public boolean checkPalindrome(String input) {
            String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

            Stack<Character> stack = new Stack<>();
            for (char c : normalized.toCharArray()) stack.push(c);

            for (char c : normalized.toCharArray()) {
                if (c != stack.pop()) return false;
            }
            return true;
        }
    }

    public static void useEncapsulatedChecker(String input) {
        PalindromeChecker checker = new PalindromeChecker();
        boolean result = checker.checkPalindrome(input);

        System.out.println(input + (result ? " is a Palindrome (OOP Encapsulation).\n"
                : " is NOT a Palindrome (OOP Encapsulation).\n"));
    }

    // ===== UC12 =====
    interface PalindromeStrategy {
        boolean isPalindrome(String input);
    }

    static class StackStrategy implements PalindromeStrategy {
        public boolean isPalindrome(String input) {
            Stack<Character> stack = new Stack<>();
            for (char c : input.toCharArray()) stack.push(c);

            for (char c : input.toCharArray()) {
                if (c != stack.pop()) return false;
            }
            return true;
        }
    }

    static class DequeStrategy implements PalindromeStrategy {
        public boolean isPalindrome(String input) {
            Deque<Character> deque = new ArrayDeque<>();
            for (char c : input.toCharArray()) deque.addLast(c);

            while (deque.size() > 1) {
                if (deque.removeFirst() != deque.removeLast()) return false;
            }
            return true;
        }
    }

    static class StrategyContext {
        private PalindromeStrategy strategy;

        public StrategyContext(PalindromeStrategy strategy) {
            this.strategy = strategy;
        }

        public boolean execute(String input) {
            return strategy.isPalindrome(input);
        }
    }

    public static void useStrategy(String input) {
        StrategyContext stackContext = new StrategyContext(new StackStrategy());
        StrategyContext dequeContext = new StrategyContext(new DequeStrategy());

        System.out.println(input + (stackContext.execute(input) ? " is Palindrome (Stack Strategy)" : " is NOT Palindrome (Stack Strategy)"));
        System.out.println(input + (dequeContext.execute(input) ? " is Palindrome (Deque Strategy)\n" : " is NOT Palindrome (Deque Strategy)\n"));
    }

    // ===== UC13: Performance Comparison =====
    public static void comparePerformance(String input) {

        long start, end;

        start = System.nanoTime();
        checkUsingCharArray(input);
        end = System.nanoTime();
        System.out.println("CharArray Time: " + (end - start) + " ns\n");

        start = System.nanoTime();
        checkUsingStack(input);
        end = System.nanoTime();
        System.out.println("Stack Time: " + (end - start) + " ns\n");

        start = System.nanoTime();
        checkUsingDeque(input);
        end = System.nanoTime();
        System.out.println("Deque Time: " + (end - start) + " ns\n");

        start = System.nanoTime();
        checkUsingRecursion(input);
        end = System.nanoTime();
        System.out.println("Recursion Time: " + (end - start) + " ns\n");
    }

    // ===== MAIN =====
    public static void main(String[] args) {

        displayAppInfo();
        checkHardcodedPalindrome();
        reverseAndCheck("racecar");
        checkUsingCharArray("level");
        checkUsingStack("radar");
        checkUsingQueueAndStack("madam");
        checkUsingDeque("civic");
        checkUsingLinkedList("refer");
        checkUsingRecursion("deified");
        checkIgnoringSpacesAndCase("A man a plan a canal Panama");
        useEncapsulatedChecker("No lemon no melon");
        useStrategy("madam");
        comparePerformance("racecar"); // UC13

        System.out.println("Program Ended.");
    }
}