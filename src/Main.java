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
        if (start >= end) return true; // base case

        if (input.charAt(start) != input.charAt(end)) return false;

        return recursiveCheck(input, start + 1, end - 1);
    }

    public static void checkUsingRecursion(String input) {
        boolean isPalindrome = recursiveCheck(input, 0, input.length() - 1);

        System.out.println(input + (isPalindrome ? " is a Palindrome.\n" : " is NOT a Palindrome.\n"));
    }

    // ===== MAIN =====
    public static void main(String[] args) {

        displayAppInfo();                   // UC1
        checkHardcodedPalindrome();         // UC2
        reverseAndCheck("racecar");         // UC3
        checkUsingCharArray("level");       // UC4
        checkUsingStack("radar");           // UC5
        checkUsingQueueAndStack("madam");   // UC6
        checkUsingDeque("civic");           // UC7
        checkUsingLinkedList("refer");      // UC8
        checkUsingRecursion("deified");     // UC9

        System.out.println("Program Ended.");
    }
}