/**
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.
 * <p>
 * Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
 * <p>
 * Return k after placing the final result in the first k slots of nums.
 * <p>
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * Custom Judge:
 * <p>
 * The judge will test your solution with the following code:
 * <p>
 * int[] nums = [...]; // Input array
 * int[] expectedNums = [...]; // The expected answer with correct length
 * <p>
 * int k = removeDuplicates(nums); // Calls your implementation
 * <p>
 * assert k == expectedNums.length;
 * for (int i = 0; i < k; i++) {
 * assert nums[i] == expectedNums[i];
 * }
 * If all assertions pass, then your solution will be accepted.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * Example 2:
 * <p>
 * Input: nums = [0,0,1,1,1,2,2,3,3,4]
 * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 * Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 3 * 104
 * -100 <= nums[i] <= 100
 * nums is sorted in non-decreasing order.
 */
public class _26_Remove_Duplicates_from_Sorted_Array {

    /**
     * Solution:
     * <p>
     * Overview
     * The problem would have been simpler if we are allowed to use extra space.
     * <p>
     * We can create a map which stores all unique array elements as the key and element frequency as the value.
     * <p>
     * After populating our map, we get all the unique elements from our array.
     * <p>
     * We then iterate our map and push all the keys in our input array
     * <p>
     * However, without using extra space it makes it a bit tricky as we have to modify the existing input array
     * <p>
     * Approach 1: Two indexes approach
     * Intuition
     * To solve the problem, let's look at the condition carefully,
     * <p>
     * It is guaranteed that the given array is a sorted array.
     * <p>
     * Let k be the count of unique elements in our input array.
     * <p>
     * It doesn't matter what elements we place after the first k elements.
     * <p>
     * From the condition, we can have a few observations here,
     * <p>
     * Since the array we have is sorted, all duplicate values will be one after the other.
     * <p>
     * We need to update the first k elements in an array with unique values and return the value of k.
     * <p>
     * Using the following intuition, let's understand how to address this problem.
     * <p>
     * The problem states that we need to fill the first k elements of an array with unique values
     * For doing so, we modify the input array in-place so that we don't use extra space
     * In order to perform in-place operations, we use the Two indexes approach
     * The first index updates the value in our input array while reading the data from the second index
     * First Index is responsible for writing unique values in our input array, while Second Index will read the input array and pass all the distinct elements to First Index.
     * <p>
     * We continue the above steps until the second index reaches the end of an array
     * Algorithm
     * By analyzing the above three key observations, we can derive the following algorithm,
     * <p>
     * Start both indexes (insertIndex, i) from 1.
     * insertIndex and i represents our First and second Index respectively.
     * <p>
     * Check if the previous element is different from the current element
     * The previous element is the element just before our i index i.e element present at arr[i-1]
     * <p>
     * If found different then perform arr[insertIndex] = arr[i] and increment insertIndex by 1
     * <p>
     * Increment i index by 1 till we reach end of the array
     * <p>
     * Note: After reaching the end of the array, our insertIndex variable will hold the count of unique elements in our input array.
     */
    public static void main(String[] args) {

        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
//        Output: 5

//        int result = removeDuplicates(nums);
//        System.out.println("result: " + result);
//        Output: 5


        // OR


        int output = removeDuplicates_(nums);
        System.out.println("Output: " + output);
//        Output: 5

    }


    //    Best practice
    // 1 ms
    public static int removeDuplicates_(int[] nums) {
        int insertIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[insertIndex] = nums[i];
                insertIndex++;
            }
        }
        return insertIndex;
    }


    // 1 ms
    public static int removeDuplicates(int[] nums) {
        int count = 0, pointer = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[pointer]) {
                nums[count] = nums[pointer];
            } else {
                pointer = i;
                count++;
                nums[count] = nums[pointer];
            }
        }
        return count + 1;
    }


}