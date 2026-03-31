package keep; /**
 * ESSENTIAL ARRAY PATTERNS FOR LEETCODE
 * Master these patterns to solve 80% of array problems
 */

import java.util.*;

public class ArrayPatterns {
    
    public static void main(String[] args) {
        System.out.println("=== ARRAY PATTERNS ===\n");
        twoPointerPattern();
        slidingWindowPattern();
        prefixSumPattern();
        kadaneAlgorithm();
    }
    
    // PATTERN 1: TWO POINTERS
    // Used in: Two Sum (sorted), Remove Duplicates, Container With Most Water
    static void twoPointerPattern() {
        System.out.println("1. TWO POINTER PATTERN");
        
        // Example: Remove duplicates from sorted array
        int[] nums = {1, 1, 2, 2, 3, 4, 4, 5};
        int uniqueCount = removeDuplicates(nums);
        System.out.print("Unique elements: ");
        for (int i = 0; i < uniqueCount; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("\n");
    }
    
    static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        
        int slow = 0;  // Points to last unique element
        
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        
        return slow + 1;
    }
    
    // PATTERN 2: SLIDING WINDOW
    // Used in: Maximum Subarray, Longest Substring, Find Anagrams
    static void slidingWindowPattern() {
        System.out.println("2. SLIDING WINDOW PATTERN");
        
        // Example: Maximum sum of k consecutive elements
        int[] nums = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        int k = 4;
        int maxSum = maxSumSubarray(nums, k);
        System.out.println("Max sum of " + k + " elements: " + maxSum + "\n");
    }
    
    static int maxSumSubarray(int[] nums, int k) {
        // Calculate sum of first window
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        
        int maxSum = windowSum;
        
        // Slide the window
        for (int i = k; i < nums.length; i++) {
            windowSum = windowSum - nums[i - k] + nums[i];  // Remove left, add right
            maxSum = Math.max(maxSum, windowSum);
        }
        
        return maxSum;
    }
    
    // PATTERN 3: PREFIX SUM
    // Used in: Subarray Sum Equals K, Range Sum Query
    static void prefixSumPattern() {
        System.out.println("3. PREFIX SUM PATTERN");
        
        int[] nums = {1, 2, 3, 4, 5};
        int[] prefixSum = buildPrefixSum(nums);
        
        System.out.println("Original: " + Arrays.toString(nums));
        System.out.println("Prefix Sum: " + Arrays.toString(prefixSum));
        
        // Query: Sum from index 1 to 3
        int left = 1, right = 3;
        int rangeSum = prefixSum[right + 1] - prefixSum[left];
        System.out.println("Sum[" + left + ":" + right + "] = " + rangeSum + "\n");
    }
    
    static int[] buildPrefixSum(int[] nums) {
        int[] prefix = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        return prefix;
    }
    
    // PATTERN 4: KADANE'S ALGORITHM
    // Used in: Maximum Subarray Sum
    static void kadaneAlgorithm() {
        System.out.println("4. KADANE'S ALGORITHM (Max Subarray Sum)");
        
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSum = kadane(nums);
        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("Maximum subarray sum: " + maxSum + "\n");
    }
    
    static int kadane(int[] nums) {
        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            // Either extend existing subarray or start new one
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        
        return maxSoFar;
    }
}
