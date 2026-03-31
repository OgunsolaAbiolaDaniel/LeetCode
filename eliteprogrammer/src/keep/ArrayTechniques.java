package keep; /**
 * ADVANCED ARRAY TECHNIQUES FOR LEETCODE
 * More sophisticated patterns and algorithms
 */

import java.util.*;

public class ArrayTechniques {
    
    public static void main(String[] args) {
        System.out.println("=== ADVANCED TECHNIQUES ===\n");
        dutchFlagProblem();
        binarySearchTechnique();
        mergeSortedArrays();
        matrixTraversal();
    }
    
    // TECHNIQUE 1: DUTCH NATIONAL FLAG (3-way partitioning)
    // Used in: Sort Colors, Partition Array
    static void dutchFlagProblem() {
        System.out.println("1. DUTCH NATIONAL FLAG");
        
        int[] nums = {2, 0, 2, 1, 1, 0};
        System.out.println("Before: " + Arrays.toString(nums));
        
        sortColors(nums);
        System.out.println("After: " + Arrays.toString(nums) + "\n");
    }
    
    static void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low++, mid++);
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high--);
            }
        }
    }
    
    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    // TECHNIQUE 2: BINARY SEARCH
    // Used in: Search in Rotated Array, Find Peak Element
    static void binarySearchTechnique() {
        System.out.println("2. BINARY SEARCH");
        
        int[] nums = {1, 3, 5, 7, 9, 11, 13};
        int target = 7;
        int index = binarySearch(nums, target);
        System.out.println("Found " + target + " at index: " + index + "\n");
    }
    
    static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;  // Prevents overflow
            
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1;
    }
    
    // TECHNIQUE 3: MERGE TWO SORTED ARRAYS
    // Used in: Merge Sorted Array, Merge K Sorted Lists
    static void mergeSortedArrays() {
        System.out.println("3. MERGE SORTED ARRAYS");
        
        int[] nums1 = {1, 3, 5, 7};
        int[] nums2 = {2, 4, 6, 8};
        int[] merged = merge(nums1, nums2);
        
        System.out.println("Array 1: " + Arrays.toString(nums1));
        System.out.println("Array 2: " + Arrays.toString(nums2));
        System.out.println("Merged: " + Arrays.toString(merged) + "\n");
    }
    
    static int[] merge(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;
        
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                result[k++] = nums1[i++];
            } else {
                result[k++] = nums2[j++];
            }
        }
        
        while (i < nums1.length) result[k++] = nums1[i++];
        while (j < nums2.length) result[k++] = nums2[j++];
        
        return result;
    }
    
    // TECHNIQUE 4: MATRIX TRAVERSAL
    // Used in: Spiral Matrix, Rotate Image
    static void matrixTraversal() {
        System.out.println("4. MATRIX TRAVERSAL");
        
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };
        
        System.out.println("Matrix:");
        printMatrix(matrix);
        
        System.out.print("Spiral order: ");
        spiralOrder(matrix);
        System.out.println("\n");
    }
    
    static void spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return;
        
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        
        while (top <= bottom && left <= right) {
            // Traverse right
            for (int i = left; i <= right; i++) {
                System.out.print(matrix[top][i] + " ");
            }
            top++;
            
            // Traverse down
            for (int i = top; i <= bottom; i++) {
                System.out.print(matrix[i][right] + " ");
            }
            right--;
            
            // Traverse left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    System.out.print(matrix[bottom][i] + " ");
                }
                bottom--;
            }
            
            // Traverse up
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    System.out.print(matrix[i][left] + " ");
                }
                left++;
            }
        }
    }
    
    static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
