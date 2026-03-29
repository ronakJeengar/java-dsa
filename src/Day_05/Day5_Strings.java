package Day_05;

import java.util.*;

public class Day5_Strings {

    public static void main(String[] args) {

        // ─────────────────────────────────────
        // 1. STRING BASICS
        // ─────────────────────────────────────
        System.out.println("=== STRING BASICS ===");
        String s = "Hello, DSA World!";

        System.out.println("Length: " + s.length());           // 17
        System.out.println("charAt(0): " + s.charAt(0));       // H
        System.out.println("charAt(7): " + s.charAt(7));       // D
        System.out.println("indexOf('o'): " + s.indexOf('o')); // 4
        System.out.println("lastIndexOf('o'): "
                + s.lastIndexOf('o'));                 // 9
        System.out.println("substring(7): "
                + s.substring(7));                    // DSA World!
        System.out.println("substring(7,10): "
                + s.substring(7, 10));                // DSA
        System.out.println("toLowerCase: " + s.toLowerCase());
        System.out.println("toUpperCase: " + s.toUpperCase());
        System.out.println("trim: " + "  hello  ".trim());    // hello
        System.out.println("replace: "
                + s.replace("DSA", "Java"));
        System.out.println("contains: "
                + s.contains("DSA"));                 // true
        System.out.println("startsWith: "
                + s.startsWith("Hello"));             // true
        System.out.println("endsWith: "
                + s.endsWith("World!"));              // true

        // ─────────────────────────────────────
        // 2. STRING COMPARISON — CRITICAL!
        // ─────────────────────────────────────
        System.out.println("\n=== STRING COMPARISON ===");
        String a = "hello";
        String b = "hello";
        String c = new String("hello");

        System.out.println("a == b: " + (a == b));           // true (pool)
        System.out.println("a == c: " + (a == c));           // false (heap)
        System.out.println("a.equals(b): " + a.equals(b));   // true ✅
        System.out.println("a.equals(c): " + a.equals(c));   // true ✅
        System.out.println("equalsIgnoreCase: "
                + "HELLO".equalsIgnoreCase("hello")); // true
        System.out.println("compareTo: "
                + "apple".compareTo("banana"));     // negative

        // ─────────────────────────────────────
        // 3. STRING ↔ CHAR ARRAY CONVERSION
        //    Most important DSA trick!
        // ─────────────────────────────────────
        System.out.println("\n=== STRING ↔ CHAR ARRAY ===");
        String str = "banana";

        // String → char[]
        char[] chars = str.toCharArray();
        System.out.println("Char array: " + Arrays.toString(chars));

        // Modify char array (can't modify String directly)
        chars[0] = 'B';
        System.out.println("Modified: " + new String(chars)); // Banana

        // char[] → String
        String back = new String(chars);
        System.out.println("Back to String: " + back);

        // Sort a string (very common in anagram problems!)
        char[] sorted = str.toCharArray();
        Arrays.sort(sorted);
        String sortedStr = new String(sorted);
        System.out.println("Sorted 'banana': " + sortedStr); // aaabnn

        // ─────────────────────────────────────
        // 4. STRINGBUILDER — The DSA Workhorse
        // ─────────────────────────────────────
        System.out.println("\n=== STRINGBUILDER ===");
        StringBuilder sb = new StringBuilder();

        sb.append("Hello");       // "Hello"
        sb.append(" ");           // "Hello "
        sb.append("World");       // "Hello World"
        sb.insert(5, ",");        // "Hello, World"
        System.out.println(sb);

        sb.reverse();
        System.out.println("Reversed: " + sb); // dlroW ,olleH

        sb.delete(0, 6);
        System.out.println("After delete: " + sb); // ,olleH

        sb.deleteCharAt(0);
        System.out.println("After deleteCharAt: " + sb); // olleH

        System.out.println("Length: " + sb.length()); // 5
        System.out.println("charAt(0): " + sb.charAt(0)); // o
        sb.setCharAt(0, 'O');
        System.out.println("After setCharAt: " + sb); // OlleH

        // ─────────────────────────────────────
        // 5. ASCII MANIPULATION — DSA Gold!
        // ─────────────────────────────────────
        System.out.println("\n=== ASCII MANIPULATION ===");
        char ch = 'A';
        System.out.println("'A' ASCII: " + (int) ch);        // 65
        System.out.println("'a' ASCII: " + (int) 'a');       // 97
        System.out.println("'A' + 32 = " + (char)(ch + 32)); // a

        // Frequency array using ASCII — O(1) space for lowercase!
        String word = "programming";
        int[] freq = new int[26]; // 26 lowercase letters
        for (char c2 : word.toCharArray()) {
            freq[c2 - 'a']++; // 'a'→0, 'b'→1, ..., 'z'→25
        }
        System.out.println("Freq of 'r': " + freq['r' - 'a']); // 2
        System.out.println("Freq of 'g': " + freq['g' - 'a']); // 2

        // ─────────────────────────────────────
        // 6. SPLIT AND JOIN
        // ─────────────────────────────────────
        System.out.println("\n=== SPLIT & JOIN ===");
        String sentence = "the quick brown fox";
        String[] words = sentence.split(" ");
        System.out.println("Words: " + Arrays.toString(words));
        System.out.println("Word count: " + words.length);     // 4

        // Reverse words in sentence
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i > 0) reversed.append(" ");
        }
        System.out.println("Reversed: " + reversed); // fox brown quick the

        // Join with String.join
        String joined = String.join("-", words);
        System.out.println("Joined: " + joined); // the-quick-brown-fox

        // ─────────────────────────────────────
        // 7. INTEGER ↔ STRING CONVERSION
        // ─────────────────────────────────────
        System.out.println("\n=== INT ↔ STRING ===");
        int num = 12345;
        String numStr = String.valueOf(num);   // int → String
        String numStr2 = Integer.toString(num); // alternative
        int backToInt = Integer.parseInt(numStr); // String → int

        System.out.println("int → String: " + numStr);
        System.out.println("String → int: " + backToInt);

        // Digit by digit from number (common DSA trick)
        for (char digit : numStr.toCharArray()) {
            System.out.print((digit - '0') + " "); // 1 2 3 4 5
        }
        System.out.println();
    }
}
