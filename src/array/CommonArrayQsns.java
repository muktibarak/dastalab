package array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class CommonArrayQsns {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,4,3,8,5};
        System.out.println(findSecondSmallest(nums));

        int[] nums1 = {1,2,3,4,5};
        int[] nums2 = {4,5,6,7,8,9,2};
        System.out.println(findCommonElements(nums1, nums2));

        System.out.println(reverseInPlace(nums1));

        String[] str = {"Apple", "Banana", "Avocado", "Jackfruit", "Cucumber"};
        System.out.println(fetchLengthOfLongestString(str));
        System.out.println(findTheLongestString(str));
    }
    /**
     * Given an array of integers, find the second smallest integer element.
     * Write a program in Java 8.
     */
    public static int findSecondSmallest(int[] nums){
        int secondSmallestNumber = Arrays.stream(nums).distinct()
                .sorted().skip(1).findFirst().orElseThrow(
                        () -> new IllegalArgumentException("No such element")
                );
        return secondSmallestNumber;
    }

    /**
     * Given an array of integers, find the common elements.
     * Write a program in Java 8.
     */
    public static List<Integer> findCommonElements(int[] nums1, int[] nums2){
        return Arrays.stream(nums1).filter(num -> Arrays.stream(nums2).anyMatch(
                num2 -> num2 == num
        )).boxed().collect(Collectors.toList());
    }

    /**
     * Write a Java 8 program to reverse an array of integers in-place.
     * @return
     */

    public static String reverseInPlace(int[] arr){
//        find the pivot point
            IntStream.range(0, arr.length/2).forEach(i -> {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;

        });
        return Arrays.toString(arr);
    }

    /**
     * Given an array of strings, write a Java 8 program to find the length of the longest string.
     * Input: String[] = {"Apple", "Banana", "Avocado", "Jackfruit", "Cucumber"}
     */

    public static int fetchLengthOfLongestString(String[] str){
        return Arrays.stream(str).mapToInt(el -> el.length()).max().orElse(0);
    }

    /**
     * Given an array of strings, write a Java 8 program to print the longest string.
     * Input: String[] = {"Apple", "Banana", "Avocado", "Jackfruit", "Cucumber"}
     */

    public static String findTheLongestString(String[] str){
       return Arrays.stream(str).max(Comparator.comparingInt(String::length)).orElse("");
    }
}
