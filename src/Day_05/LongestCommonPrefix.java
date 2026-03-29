package Day_05;

/*
 Problem: Longest Common Prefix
 Category: Strings
 Day: 05
 Platform: LeetCode

 Description:
 Find the longest prefix shared
 among all strings in an array.

 Example:
 Input: ["flower","flow","flight"]
 Output: "fl"

 Approach:
 Start with first string as prefix.
 Reduce prefix until match found.

 Time Complexity: O(n × m)
 Space Complexity: O(1)
*/

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        // Take first string as reference
        String prefix = strs[0];

        // Compare prefix with each string
        for (int i = 1; i < strs.length; i++) {
            // Shrink prefix until it matches start of strs[i]
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(
                new String[]{"flower","flow","flight"})); // "fl"
        System.out.println(longestCommonPrefix(
                new String[]{"dog","racecar","car"}));    // ""
        System.out.println(longestCommonPrefix(
                new String[]{"interview","inter","internal"})); // "inter"
    }
}