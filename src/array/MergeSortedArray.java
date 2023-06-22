package array;

import java.util.Arrays;

/**
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
 * and two integers m and n,
 * representing the number of elements in nums1 and nums2 respectively.
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 *
 * The final sorted array should not be returned by the function,
 * but instead be stored inside the array nums1.
 *
 * To accommodate this, nums1 has a length of m + n, where the first m elements
 * denote the elements that should be merged, and the last n elements are set to 0
 * and should be ignored. nums2 has a length of n.
 * *
 *
 * We can solve this by similar to merge sort algorithm where we compare elements
 * from each array and place the biggest number at the end of merged array (in this case
 * nums1). Iterating from the end to the begin would ensure there would be no
 *
 *
 */

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        System.out.println(merge(nums1, nums2, 3, 3));
    }

    public static String merge(int[] nums1, int[] nums2, int m, int n){
       int i = m -1; // index of the last element on nums1
       int j = n -1; // index of the last element on nums2
       int k = m + n - 1; // index of the last element on merged array (in this case nums1)
       while (i >= 0 && j >= 0){
           if(nums1[i] > nums2[j]){
               nums1[k] = nums1[i];
               i--;
           } else {
               nums1[k] = nums2[j];
               j--;
           }
           k--;
       }
//       this loop is for edge cases like any remaining numbers in nums2 like nums1 = [0] and nums2 = [1]
       while (j >= 0){
           nums1[k] = nums2[j];
           j--;
           k--;
       }
       return Arrays.toString(nums1);

    }
}
