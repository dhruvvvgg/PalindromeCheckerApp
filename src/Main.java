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

        // Reverse using for loop
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed = reversed + input.charAt(i);  // String concatenation
        }

        // Compare using equals()
        if (input.equals(reversed)) {
            System.out.println(input + " is a Palindrome.");
        } else {
            System.out.println(input + " is NOT a Palindrome.");
        }

        System.out.println();
    }

    // ===== Main Method =====
    public static void main(String[] args) {

        displayAppInfo();                 // UC1
        checkHardcodedPalindrome();       // UC2
        reverseAndCheck("racecar");       // UC3

        System.out.println("Program Ended.");
    }
}