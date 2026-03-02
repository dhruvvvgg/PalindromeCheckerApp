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
        String word = "madam";  // String Literal

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

    // ===== Main Method (Entry Point) =====
    public static void main(String[] args) {

        displayAppInfo();          // UC1
        checkHardcodedPalindrome(); // UC2

        System.out.println("Program Ended.");
    }
}