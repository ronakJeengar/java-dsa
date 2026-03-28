package Day_01;

public class Day1_Basics {

    public static void main(String[] args) {
        // ─────────────────────────────────
        // 1. PRIMITIVE DATA TYPES
        // ─────────────────────────────────
        int age = 25;              // whole numbers
        long bigNumber = 9999999999L; // L suffix for long
        double pi = 3.14159;       // decimal numbers
        char grade = 'A';          // single character
        boolean isEven = true;     // true or false
        String name = "DSA Hero";  // not primitive, but used everywhere

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("bigNumber: " + bigNumber);
        System.out.println("pi: " + pi);
        System.out.println("grade: " + grade);
        System.out.println("isEven: " + isEven);

        // ─────────────────────────────────
        // 2. ARRAYS — Core of DSA
        // ─────────────────────────────────
        int[] arr = {10, 20, 30, 40, 50}; // declare + initialize
        int n = arr.length;                // length property

        System.out.println("Array length: " + n);
        System.out.println("First element: " + arr[0]);
        System.out.println("Last element: " + arr[n - 1]);

        // 3. FOR LOOP — Traversing array
        // ─────────────────────────────────
        System.out.print("Array elements: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // ─────────────────────────────────
        // 4. ENHANCED FOR LOOP (for-each)
        // ─────────────────────────────────
        System.out.print("Using for-each: ");
        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();

        // ─────────────────────────────────
        // 5. WHILE LOOP
        // ─────────────────────────────────
        int i = 0;
        int sum = 0;
        while (i < n) {
            sum += arr[i];
            i++;
        }
        System.out.println("Sum of array: " + sum);


        // ─────────────────────────────────
        // 6. IF / ELSE
        // ─────────────────────────────────
        if (sum % 2 == 0) {
            System.out.println("Sum is EVEN");
        } else {
            System.out.println("Sum is ODD");
        }

        // ─────────────────────────────────
        // 7. INT OVERFLOW DEMO
        // ─────────────────────────────────
        int a = 2_000_000_000;
        int b = 2_000_000_000;
        int wrong = a + b;        // ❌ Overflows!
        long correct = (long) a + b; // ✅ Cast first
//      int sum = Math.addExact(a, b);
        System.out.println("sum: " + sum);
        System.out.println("Correct large sum: " + correct);

        // ─────────────────────────────────
        // 8. 2D ARRAY (Matrix)
        // ─────────────────────────────────
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Matrix:");
        for (int[] ints : matrix) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(ints[col] + " ");
            }
            System.out.println();
        }

    }
}
