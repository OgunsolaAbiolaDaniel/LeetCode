package keep; /**
 * REAL LEETCODE PROBLEMS - SOLUTIONS
 * Common array problems with explanations
 */

import java.util.*;

public class LeetCodeExamples {
    
    public static void main(String[] args) {
        System.out.println("=== LEETCODE EXAMPLES ===\n");
        example1_TwoSum();
        example2_BestTimeToBuyStock();
        example3_ContainsDuplicate();
        example4_ProductExceptSelf();
    }
    
    // PROBLEM 1: Two Sum (LeetCode #1)
    // Given array and target, return indices of two numbers that add up to target
    static void example1_TwoSum() {
        System.out.println("1. TWO SUM");
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println("Input: " + Arrays.toString(nums) + ", Target: " + target);
        System.out.println("Output: " + Arrays.toString(result) + "\n");
    }
    
    static int[] twoSum(int[] nums, int target) {
        // HashMap to store value -> index
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            
            map.put(nums[i], i);
        }
        
        return new int[]{-1, -1};
    }
    
    // PROBLEM 2: Best Time to Buy and Sell Stock (LeetCode #121)
    // Find max profit from one buy and one sell
    static void example2_BestTimeToBuyStock() {
        System.out.println("2. BEST TIME TO BUY/SELL STOCK");
        int[] prices = {7, 1, 5, 3, 6, 4};
        int profit = maxProfit(prices);
        System.out.println("Prices: " + Arrays.toString(prices));
        System.out.println("Max profit: " + profit + "\n");
    }
    
    static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for (int price : prices) {
            // Track minimum price seen so far
            minPrice = Math.min(minPrice, price);
            // Calculate profit if we sell today
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        
        return maxProfit;
    }
    
    // PROBLEM 3: Contains Duplicate (LeetCode #217)
    // Check if array contains duplicates
    static void example3_ContainsDuplicate() {
        System.out.println("3. CONTAINS DUPLICATE");
        int[] nums = {1, 2, 3, 1};
        boolean hasDuplicate = containsDuplicate(nums);
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Has duplicate: " + hasDuplicate + "\n");
    }
    
    static boolean containsDuplicate(int[] nums) {
        // Method 1: Using HashSet (O(n) time, O(n) space)
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (!seen.add(num)) {  // add() returns false if already exists
                return true;
            }
        }
        return false;
        
        // Method 2: Sorting (O(n log n) time, O(1) space)
        // Arrays.sort(nums);
        // for (int i = 1; i < nums.length; i++) {
        //     if (nums[i] == nums[i-1]) return true;
        // }
        // return false;
    }
    
    // PROBLEM 4: Product of Array Except Self (LeetCode #238)
    // Return array where each element is product of all others
    static void example4_ProductExceptSelf() {
        System.out.println("4. PRODUCT OF ARRAY EXCEPT SELF");
        int[] nums = {1, 2, 3, 4};
        int[] result = productExceptSelf(nums);
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + Arrays.toString(result));
        System.out.println("(Without using division!)\n");
    }
    
    static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        // Calculate left products
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        
        // Calculate right products and multiply
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= right;
            right *= nums[i];
        }
        
        return result;
    }
}
