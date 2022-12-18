import java.util.Arrays;

/*
75. Sort Colors

Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]

Constraints:

n == nums.length
1 <= n <= 300
nums[i] is either 0, 1, or 2.

Follow up: Could you come up with a one-pass algorithm using only constant extra space?
 */
public class _75_Sort_Colors {

    /*
    1. First Approach (Using sorting)
    */

    /*
    2. Second Approach (Using counting sort)
    Use three counter variables to keep track of the count of total 0’s , 1’s and 2’s which will take a time complexity of O(n).
    Now again traverse the array and put the array elements in order by using the counter variable , so again time complexity is O(n)
    So total time complexity - O(2n) which means it is done in two passes.
    Space Complexity - O(1)
     */
    public static int[] sortColors(int[] nums) {
        int count0 = 0, count1 = 0, count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count0++;
            } else if (nums[i] == 1) {
                count1++;
            } else {
                count2++;
            }
        }

        int i = 0;
        while (count0 > 0) {
            nums[i++] = 0;
            count0--;
        }
        while (count1 > 0) {
            nums[i++] = 1;
            count1--;
        }
        while (count2 > 0) {
            nums[i++] = 2;
            count2--;
        }
        return nums;
    }

    /*
    3. Third Approach (Using the concept of “The Dutch National Flag” problem)

    Now this approach is basically based on the concept of The Dutch National Flag Problem. This is basically an approach where we divide our array into partitions which are :
    1. array[0 to low-1] = 0 is present
    2. array[low to mid-1] = 1 is present
    3. array[mid to high-1] = unknown
    4. array[high to n(size of array)] = 2 is present

    Whenever I see 0, I swap it with element present at low position.
    When I get 1, I just let it be and when i encounter 2 I swap it with element at high position.
    Similarly I keep incrementing and decrementig the variables - high, low and mid.
     */
    // Best Practice
    // 0 ms
    public static int[] sortColorsTheDutchNationalFlag(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                int[] swap = swap(nums[mid], nums[low]);
                nums[mid] = swap[0];
                nums[low] = swap[1];
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                int[] swap = swap(nums[mid], nums[high]);
                nums[mid] = swap[0];
                nums[high] = swap[1];
                high--;
            }
        }
        return nums;
    }

    public static int[] swap(int num1, int num2) {
        return new int[]{num2, num1};
    }

    public static void main(String[] args) {

        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        int[] output = sortColorsTheDutchNationalFlag(nums);
        System.out.println("Output: " + Arrays.toString(output));
    }
}


