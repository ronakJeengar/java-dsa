package Day_04;

/*
Day: 04
Topic: Java Collections Framework for DSA

Description:
This file demonstrates commonly used Java Collections
that are heavily used in Data Structures and Algorithms.

Collections Covered:

1. ArrayList
   → Dynamic Array
   → Fast random access

2. Stack (using Deque)
   → LIFO structure

3. Queue (using Deque)
   → FIFO structure

4. Deque
   → Double-ended queue

5. PriorityQueue
   → Min Heap / Max Heap

6. HashMap
   → Key-value storage
   → Frequency counting

7. HashSet
   → Unique elements
   → Duplicate detection

8. TreeMap
   → Sorted key-value map

Importance in DSA:

These structures are used in:

- BFS / DFS
- Sliding Window
- Graph Problems
- Heap Problems
- Frequency Counting
- Caching
- Scheduling

Time Complexity Focus:
Understanding operation complexity
is essential for writing optimized solutions.

*/

import java.util.*;

public class Day4_Collections {

    public static void main(String[] args) {

        // ─────────────────────────────────────
        // 1. ARRAYLIST — Dynamic Array
        // ─────────────────────────────────────
        System.out.println("=== ARRAYLIST ===");
        ArrayList<Integer> list = new ArrayList<>();

        list.add(10);           // add to end → O(1)
        list.add(20);
        list.add(30);
        list.add(1, 15);        // insert at index 1 → O(n)
        System.out.println("List: " + list);          // [10, 15, 20, 30]
        System.out.println("Get(2): " + list.get(2)); // 20 → O(1)
        list.remove(Integer.valueOf(15));              // remove by value
        System.out.println("After remove: " + list);  // [10, 20, 30]
        System.out.println("Size: " + list.size());   // 3
        System.out.println("Contains 20: " + list.contains(20)); // true

        // Sort ArrayList
        Collections.sort(list);
        System.out.println("Sorted: " + list);

        // Convert array to ArrayList
        Integer[] arr = {5, 3, 8, 1};
        ArrayList<Integer> fromArray = new ArrayList<>(Arrays.asList(arr));
        System.out.println("From array: " + fromArray);

        // ─────────────────────────────────────
        // 2. STACK using Deque (PREFERRED WAY)
        //    LIFO: Last In First Out
        // ─────────────────────────────────────
        System.out.println("\n=== STACK (Deque) ===");
        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(1);    // push to top → O(1)
        stack.push(2);
        stack.push(3);
        System.out.println("Stack: " + stack);        // [3, 2, 1]
        System.out.println("Peek: " + stack.peek());  // 3 (top, no remove)
        System.out.println("Pop: " + stack.pop());    // 3 (remove top)
        System.out.println("After pop: " + stack);    // [2, 1]
        System.out.println("Empty: " + stack.isEmpty());

        // ─────────────────────────────────────
        // 3. QUEUE using Deque (PREFERRED WAY)
        //    FIFO: First In First Out
        // ─────────────────────────────────────
        System.out.println("\n=== QUEUE (Deque) ===");
        Deque<Integer> queue = new ArrayDeque<>();

        queue.offer(1);   // enqueue to rear → O(1)
        queue.offer(2);
        queue.offer(3);
        System.out.println("Queue: " + queue);          // [1, 2, 3]
        System.out.println("Peek: " + queue.peek());    // 1 (front)
        System.out.println("Poll: " + queue.poll());    // 1 (remove front)
        System.out.println("After poll: " + queue);     // [2, 3]

        // ─────────────────────────────────────
        // 4. DEQUE — Double Ended Queue
        //    Can add/remove from BOTH ends
        // ─────────────────────────────────────
        System.out.println("\n=== DEQUE ===");
        Deque<Integer> deque = new ArrayDeque<>();

        deque.addFirst(2);  // add to front
        deque.addFirst(1);
        deque.addLast(3);   // add to back
        deque.addLast(4);
        System.out.println("Deque: " + deque);             // [1, 2, 3, 4]
        System.out.println("PeekFirst: " + deque.peekFirst()); // 1
        System.out.println("PeekLast: " + deque.peekLast());   // 4
        deque.pollFirst();  // remove from front
        deque.pollLast();   // remove from back
        System.out.println("After polls: " + deque);       // [2, 3]

        // ─────────────────────────────────────
        // 5. PRIORITY QUEUE — Heap
        // ─────────────────────────────────────
        System.out.println("\n=== PRIORITY QUEUE ===");

        // Min Heap (default)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(5);
        minHeap.offer(1);
        minHeap.offer(3);
        minHeap.offer(2);
        System.out.print("Min Heap poll order: ");
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " "); // 1 2 3 5
        }
        System.out.println();

        // Max Heap
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.offer(5);
        maxHeap.offer(1);
        maxHeap.offer(3);
        maxHeap.offer(2);
        System.out.print("Max Heap poll order: ");
        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.poll() + " "); // 5 3 2 1
        }
        System.out.println();

        // ─────────────────────────────────────
        // 6. HASHMAP — Key-Value Store O(1)
        // ─────────────────────────────────────
        System.out.println("\n=== HASHMAP ===");
        HashMap<String, Integer> map = new HashMap<>();

        map.put("Alice", 90);       // insert
        map.put("Bob", 85);
        map.put("Charlie", 92);
        map.put("Alice", 95);       // update (overwrites)

        System.out.println("Map: " + map);
        System.out.println("Alice's score: " + map.get("Alice")); // 95
        System.out.println("Contains Bob: " + map.containsKey("Bob")); // true
        System.out.println("Dave (default): " +
                map.getOrDefault("Dave", 0)); // 0

        // Frequency count — EXTREMELY common in DSA!
        int[] nums = {1, 2, 2, 3, 3, 3, 4};
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        System.out.println("Frequency: " + freq); // {1=1, 2=2, 3=3, 4=1}

        // Iterate HashMap
        System.out.println("Iterating map:");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("  " + entry.getKey()
                    + " → " + entry.getValue());
        }

        // ─────────────────────────────────────
        // 7. HASHSET — Unique Elements O(1)
        // ─────────────────────────────────────
        System.out.println("\n=== HASHSET ===");
        HashSet<Integer> set = new HashSet<>();

        set.add(1);
        set.add(2);
        set.add(3);
        set.add(2); // duplicate — ignored!
        System.out.println("Set: " + set);             // [1, 2, 3]
        System.out.println("Contains 2: " + set.contains(2)); // true
        set.remove(2);
        System.out.println("After remove: " + set);   // [1, 3]

        // Check for duplicates in array — classic DSA use!
        int[] testArr = {1, 2, 3, 4, 2};
        HashSet<Integer> seen = new HashSet<>();
        boolean hasDuplicate = false;
        for (int x : testArr) {
            if (!seen.add(x)) { // add() returns false if already exists
                hasDuplicate = true;
                break;
            }
        }
        System.out.println("Has duplicate: " + hasDuplicate); // true

        // ─────────────────────────────────────
        // 8. TREEMAP — Sorted Map O(log n)
        // ─────────────────────────────────────
        System.out.println("\n=== TREEMAP ===");
        TreeMap<Integer, String> treeMap = new TreeMap<>();

        treeMap.put(3, "Three");
        treeMap.put(1, "One");
        treeMap.put(4, "Four");
        treeMap.put(2, "Two");

        System.out.println("TreeMap: " + treeMap); // {1=One, 2=Two, 3=Three, 4=Four}
        System.out.println("First key: " + treeMap.firstKey()); // 1
        System.out.println("Last key: " + treeMap.lastKey());   // 4
        System.out.println("Floor(3): " + treeMap.floorKey(3)); // 3 (≤ 3)
        System.out.println("Ceiling(3): " + treeMap.ceilingKey(3)); // 3 (≥ 3)
        System.out.println("Lower(3): " + treeMap.lowerKey(3));     // 2 (< 3)
        System.out.println("Higher(3): " + treeMap.higherKey(3));   // 4 (> 3)
    }
}

