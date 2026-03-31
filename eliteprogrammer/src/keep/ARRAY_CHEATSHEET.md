# Java Arrays Cheat Sheet for LeetCode

## 📚 Table of Contents
1. [Array Basics](#array-basics)
2. [Essential Patterns](#essential-patterns)
3. [Time Complexity Guide](#time-complexity)
4. [Common Pitfalls](#common-pitfalls)
5. [Practice Problems](#practice-problems)

---

## Array Basics

### Declaration & Initialization
```java
// Basic arrays
int[] arr = new int[5];           // [0, 0, 0, 0, 0]
int[] arr = {1, 2, 3, 4, 5};      // With values
int[] arr = new int[]{1, 2, 3};   // Alternative

// 2D arrays (matrices)
int[][] matrix = new int[3][4];   // 3 rows, 4 cols
int[][] matrix = {{1,2}, {3,4}};  // With values

// Common properties
arr.length                         // Array size
matrix.length                      // Number of rows
matrix[0].length                   // Number of columns
```

### Important Methods
```java
Arrays.sort(arr);                      // Sort ascending
Arrays.sort(arr, Collections.reverseOrder()); // Descending (Integer[])
Arrays.toString(arr);                  // "[1, 2, 3, 4]"
Arrays.fill(arr, value);               // Fill with value
Arrays.copyOf(arr, newLength);         // Copy array
Arrays.equals(arr1, arr2);             // Compare arrays
```

---

## Essential Patterns

### 1. Two Pointers
**When to use:** Sorted arrays, finding pairs, removing elements
```java
// Pattern: One from each end
int left = 0, right = arr.length - 1;
while (left < right) {
    if (condition) {
        // Found solution
    } else if (needSmaller) {
        right--;
    } else {
        left++;
    }
}

// Pattern: Fast and slow pointers
int slow = 0;
for (int fast = 0; fast < arr.length; fast++) {
    if (condition) {
        arr[slow++] = arr[fast];
    }
}
```

### 2. Sliding Window
**When to use:** Subarrays, consecutive elements, k-sized windows
```java
// Fixed window size
int windowSum = 0;
for (int i = 0; i < k; i++) {
    windowSum += arr[i];
}
int maxSum = windowSum;

for (int i = k; i < arr.length; i++) {
    windowSum = windowSum - arr[i-k] + arr[i];
    maxSum = Math.max(maxSum, windowSum);
}

// Variable window size
int left = 0, right = 0;
while (right < arr.length) {
    // Expand window
    add(arr[right]);
    right++;
    
    // Shrink window while invalid
    while (invalid) {
        remove(arr[left]);
        left++;
    }
    
    // Update result
}
```

### 3. Prefix Sum
**When to use:** Range queries, subarray sums
```java
// Build prefix sum array
int[] prefix = new int[n + 1];
for (int i = 0; i < n; i++) {
    prefix[i + 1] = prefix[i] + arr[i];
}

// Query sum from index i to j
int rangeSum = prefix[j + 1] - prefix[i];
```

### 4. Hash Map / Set
**When to use:** Finding complements, tracking seen elements
```java
Map<Integer, Integer> map = new HashMap<>();
Set<Integer> set = new HashSet<>();

// Two Sum pattern
for (int i = 0; i < arr.length; i++) {
    int complement = target - arr[i];
    if (map.containsKey(complement)) {
        return new int[]{map.get(complement), i};
    }
    map.put(arr[i], i);
}

// Check duplicates
for (int num : arr) {
    if (!set.add(num)) return true; // Duplicate found
}
```

### 5. Binary Search
**When to use:** Sorted arrays, finding elements
```java
int left = 0, right = arr.length - 1;
while (left <= right) {
    int mid = left + (right - left) / 2; // Prevent overflow
    
    if (arr[mid] == target) {
        return mid;
    } else if (arr[mid] < target) {
        left = mid + 1;
    } else {
        right = mid - 1;
    }
}
return -1; // Not found
```

### 6. Kadane's Algorithm
**When to use:** Maximum subarray sum
```java
int maxSum = arr[0];
int currentSum = arr[0];

for (int i = 1; i < arr.length; i++) {
    currentSum = Math.max(arr[i], currentSum + arr[i]);
    maxSum = Math.max(maxSum, currentSum);
}
```

---

## Time Complexity Guide

| Operation | Time | Example |
|-----------|------|---------|
| Access element | O(1) | `arr[i]` |
| Linear search | O(n) | Find element |
| Binary search | O(log n) | Sorted array |
| Sort | O(n log n) | `Arrays.sort()` |
| Two pointers | O(n) | One pass |
| Sliding window | O(n) | One pass |
| Prefix sum | O(n) | Build + query |
| Hash map lookup | O(1) avg | `map.get(key)` |
| Nested loops | O(n²) | Brute force |

---

## Common Pitfalls

### 1. Index Out of Bounds
```java
// ❌ Wrong
for (int i = 0; i <= arr.length; i++)  // Crashes!

// ✅ Correct
for (int i = 0; i < arr.length; i++)
```

### 2. Integer Overflow
```java
// ❌ Can overflow
int mid = (left + right) / 2;

// ✅ Safe
int mid = left + (right - left) / 2;
```

### 3. Array vs ArrayList
```java
// Arrays - Fixed size
int[] arr = new int[5];
arr.length  // Property

// ArrayList - Dynamic size
List<Integer> list = new ArrayList<>();
list.size()  // Method
list.add(value)
list.get(index)
```

### 4. Primitive vs Object Arrays
```java
// ❌ Can't use Collections on primitives
int[] arr = {3, 1, 2};
Arrays.sort(arr, Collections.reverseOrder()); // Won't work!

// ✅ Use wrapper class
Integer[] arr = {3, 1, 2};
Arrays.sort(arr, Collections.reverseOrder()); // Works!
```

### 5. Array Modification During Iteration
```java
// ❌ Wrong
for (int num : arr) {
    if (condition) arr[i] = newValue; // i not defined!
}

// ✅ Correct
for (int i = 0; i < arr.length; i++) {
    if (condition) arr[i] = newValue;
}
```

---

## Practice Problems

### Easy
- [ ] Two Sum (LC #1)
- [ ] Best Time to Buy/Sell Stock (LC #121)
- [ ] Contains Duplicate (LC #217)
- [ ] Maximum Subarray (LC #53)
- [ ] Merge Sorted Array (LC #88)
- [ ] Remove Duplicates from Sorted Array (LC #26)

### Medium
- [ ] Product of Array Except Self (LC #238)
- [ ] 3Sum (LC #15)
- [ ] Container With Most Water (LC #11)
- [ ] Rotate Image (LC #48)
- [ ] Spiral Matrix (LC #54)
- [ ] Sort Colors (LC #75)

### Hard
- [ ] Trapping Rain Water (LC #42)
- [ ] First Missing Positive (LC #41)
- [ ] Median of Two Sorted Arrays (LC #4)

---

## Quick Tips

1. **Always check edge cases:**
   - Empty array: `arr.length == 0`
   - Single element: `arr.length == 1`
   - All same elements
   - Already sorted

2. **Space-time tradeoff:**
   - Use HashMap for O(n) time but O(n) space
   - Sort for O(n log n) time but O(1) space

3. **Common tricks:**
   - Reverse by swapping: `arr[i] ↔ arr[n-1-i]`
   - Find middle: `arr[n/2]`
   - Check sorted: `arr[i] <= arr[i+1]` for all i

4. **When stuck:**
   - Draw it out on paper
   - Try brute force first
   - Look for patterns in examples
   - Think about what data structure helps

---

**Remember:** Practice is key! Run the example files and solve problems daily. 🚀
