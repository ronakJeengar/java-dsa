package Day_04;

/*
Problem: Top K Frequent Elements
Platform: LeetCode

Description:
Given an integer array nums and an integer k,
return the k most frequent elements.

Example:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Approach:

1. Count frequencies using HashMap
2. Use Min Heap of size k
3. Remove the smallest frequency when size > k
4. Extract results from heap

Why Min Heap?

We only keep the top k frequent elements.
Least frequent element is removed first.

Time Complexity:
O(n log k)

Space Complexity:
O(n)

Concepts:
- HashMap (Frequency Counting)
- PriorityQueue (Min Heap)
- Heap Optimization

Day: 04
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequent {

    public static int[] topKFrequent(int[] nums, int k) {

        // Step 1: Count frequencies
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Step 2: Min heap of size k (keeps top k elements)
        // Comparator: sort by frequency ascending (min heap)
        PriorityQueue<Integer> minHeap =
                new PriorityQueue<>((a, b) -> freq.get(a) - freq.get(b));

        for (int num : freq.keySet()) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // remove least frequent
            }
        }

        // Step 3: Extract results
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = minHeap.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] result = topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        System.out.println(Arrays.toString(result)); // [1, 2]
    }
}
