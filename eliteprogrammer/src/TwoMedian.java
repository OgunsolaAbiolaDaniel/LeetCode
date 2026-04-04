
import java.util.Arrays;
public class TwoMedian {
    /*
    * 4. Median of Two Sorted Arrays
LABEL:Hard
Topics

Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).



Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.

Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
    * */

    public static void main(String[] args){
        int[] nums1 = {1, 2}, nums2 = {3,4};
        System.out.print(findMedianSortedArrays(nums1,nums2));

    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // middle number from two sorted arrays ;
        // combine the two arrays  to on array ;
        //then use median formula when n is odd
        int size = nums1.length + nums2.length ;
        int  counter = 0 ;
        double evenMed= 0.0;
        int[] Total_Array  = new int[size];
        for (int i = 0; i <nums1.length; i++){
            Total_Array[i]= nums1[i];
            counter++;
        }
        for (int j = 0; j< nums2.length ; j++){
            Total_Array[counter] = nums2[j];
            counter++;
        }
        //sucessfully pushed both array values to total arry
        //sort the total arr
        Arrays.sort(Total_Array);
        //time for median alg;
        if(size%2==0){
            int middle1=  (size/2)-1;
            int middle2 = (size/2);
            double sums =  Total_Array[middle1] + Total_Array[middle2];
            evenMed = sums/2;
        }
        else {
            evenMed = Total_Array[(size/2)];
        }


        return evenMed;


    }


}
