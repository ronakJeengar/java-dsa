package Day_03;

/*
Day: 03
Topic: Object-Oriented Programming (OOP) Foundations for DSA

Concepts Covered:

1. Node Class
   → Foundation of Linked Lists
   → Used in Trees and Graphs

2. TreeNode Class
   → Foundation of Binary Trees & BST

3. Comparable Interface
   → Natural sorting logic

4. Comparator Interface
   → Custom sorting logic

5. Pair Class
   → Useful for storing (index, value)
   → Common in Graph & Matrix problems

6. Lambda Comparator
   → Modern Java sorting method

7. Null Safety Checks
   → Avoid NullPointerException

Key Importance:
These structures are heavily used in:
- Linked Lists
- Trees
- Graphs
- Priority Queues
- Sorting problems

*/

import java.util.*;

public class Day3_OOP {

    // ─────────────────────────────────────────
    // 1. NODE CLASS — Foundation of all DSA
    //    Used in: LinkedList, Tree, Graph
    // ─────────────────────────────────────────
    static class Node {
        int val;       // data stored
        Node next;     // pointer to next node

        // Constructor 1: with value
        Node(int val) {
            this.val = val;
            this.next = null; // explicitly set to null
        }

        // Constructor 2: with value and next
        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    // ─────────────────────────────────────────
    // 2. TREE NODE CLASS
    //    Used in: Binary Trees, BST
    // ─────────────────────────────────────────
    static class TreeNode {
        int val;
        TreeNode left;   // left child
        TreeNode right;  // right child

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    // ─────────────────────────────────────────
    // 3. CUSTOM CLASS WITH COMPARABLE
    //    Allows natural sorting by age
    // ─────────────────────────────────────────
    static class Student implements Comparable<Student> {
        String name;
        int age;
        double gpa;

        Student(String name, int age, double gpa) {
            this.name = name;
            this.age = age;
            this.gpa = gpa;
        }

        // Natural ordering: sort by age (ascending)
        @Override
        public int compareTo(Student other) {
            return this.age - other.age;
            // Negative → this comes first
            // Zero     → equal
            // Positive → other comes first
        }

        @Override
        public String toString() {
            return name + "(age=" + age + ", gpa=" + gpa + ")";
        }
    }

    // ─────────────────────────────────────────
    // 4. COMPARATOR — Custom sort orders
    // ─────────────────────────────────────────

    // Sort by GPA descending (highest first)
    static class SortByGPADesc implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return Double.compare(s2.gpa, s1.gpa); // note: s2 first = descending
        }
    }

    // Sort by name alphabetically
    static class SortByName implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return s1.name.compareTo(s2.name);
        }
    }

    // ─────────────────────────────────────────
    // 5. PAIR CLASS — Very useful in DSA!
    //    Use for: storing (index, value),
    //    (distance, node), (row, col) pairs
    // ─────────────────────────────────────────
    static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() {
            return "(" + first + ", " + second + ")";
        }
    }

    // ─────────────────────────────────────────
    // MAIN METHOD
    // ─────────────────────────────────────────
    public static void main(String[] args) {

        // ── Test Node class ──
        System.out.println("=== NODE CLASS ===");
        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);

        // Manually link: 10 → 20 → 30
        n1.next = n2;
        n2.next = n3;

        // Traverse linked nodes
        Node current = n1;
        System.out.print("Linked Nodes: ");
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) System.out.print(" → ");
            current = current.next;
        }
        System.out.println();

        // ── Test TreeNode class ──
        System.out.println("\n=== TREE NODE CLASS ===");
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        /*
            Tree structure:
                  1
                 / \
                2   3
               / \
              4   5
        */
        System.out.println("Root: " + root.val);
        System.out.println("Left child: " + root.left.val);
        System.out.println("Right child: " + root.right.val);
        System.out.println("Left-Left: " + root.left.left.val);

        // ── Test Comparable ──
        System.out.println("\n=== COMPARABLE SORT ===");
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 22, 3.9));
        students.add(new Student("Bob", 19, 3.5));
        students.add(new Student("Charlie", 21, 3.7));
        students.add(new Student("Diana", 20, 3.8));

        Collections.sort(students); // uses compareTo → sort by age
        System.out.println("Sorted by Age (natural):");
        for (Student s : students) System.out.println("  " + s);

        // ── Test Comparator ──
        System.out.println("\nSorted by GPA (descending):");
        students.sort(new SortByGPADesc());
        for (Student s : students) System.out.println("  " + s);

        System.out.println("\nSorted by Name:");
        students.sort(new SortByName());
        for (Student s : students) System.out.println("  " + s);

        // ── Lambda Comparator (Modern Java) ──
        System.out.println("\nLambda sort by GPA ascending:");
        students.sort((s1, s2) -> Double.compare(s1.gpa, s2.gpa));
        for (Student s : students) System.out.println("  " + s);

        // ── Test Pair class ──
        System.out.println("\n=== PAIR CLASS ===");
        Pair p = new Pair(3, 7);
        System.out.println("Pair: " + p);

        // ArrayList of Pairs — used in graph problems!
        List<Pair> edges = new ArrayList<>();
        edges.add(new Pair(0, 1));
        edges.add(new Pair(1, 2));
        edges.add(new Pair(0, 2));
        System.out.println("Graph edges: " + edges);

        // ── NULL safety demo ──
        System.out.println("\n=== NULL SAFETY ===");
        Node nullNode = null;
        // nullNode.val ← This would throw NullPointerException!

        // Always check before accessing:
        if (nullNode != null) {
            System.out.println(nullNode.val);
        } else {
            System.out.println("Node is null — safe check passed!");
        }
    }
}
