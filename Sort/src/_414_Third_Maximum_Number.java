/*
414. Third Maximum Number

Given an integer array nums, return the third distinct maximum number in this array. If the third maximum does not exist, return the maximum number.
Example 1:

Input: nums = [3,2,1]
Output: 1
Explanation:
The first distinct maximum is 3.
The second distinct maximum is 2.
The third distinct maximum is 1.
Example 2:

Input: nums = [1,2]
Output: 2
Explanation:
The first distinct maximum is 2.
The second distinct maximum is 1.
The third distinct maximum does not exist, so the maximum (2) is returned instead.
Example 3:

Input: nums = [2,2,3,1]
Output: 1
Explanation:
The first distinct maximum is 3.
The second distinct maximum is 2 (both 2's are counted together since they have the same value).
The third distinct maximum is 1.

Constraints:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1

Follow up: Can you find an O(n) solution?
 */
public class _414_Third_Maximum_Number {

    /*
    Overview
    In this problem, we have to return the 3rd largest number and if it does not exist we have to return the largest number.

    In problems where we have to find kth largest/smallest number, we can always start by using any one of these three methods, sorting the array, using a priority queue, or using a sorted set. As these three methods keep array elements in sorted order and it's easy to find the required element.

    Also, we can keep track of the 3rd largest number using 3 pointers which point to the top 3 largest numbers of the array.
    Let's explore all of these approaches in detail.
     */

    /*
    Approach 4: 3 Pointers
    Intuition
    We know we only have to keep track of the top three largest numbers of arrays while traversing through it.
    This could also be done by using three variables, firstMax, which stores the largest number in the array till now, secondMax, which stores the second largest number till now, and, thirdMax, which stores the third largest number.

    We will use long integer variable because the minimum possible value in the input array is $-2^{31}$, and initially, we need to store a value lower than this. In the end we compared if the thirdMax variable is equal to the initial value, to check if we had three different numbers in our array or not. But if we store −231-2^{31}−2
    31
      as the initial value then, it will not give the correct answer.

    For example, consider a case, array = [1, 2, 3, 1].
    Now at the end, firstMax = 2, secondMax = 1, thirdMax = MIN_VALUE.
    Thus, now we will think thirdMax still has the initial value thus this variable is not changed and we will assume the array doesn't have 3 different numbers and will return the wrong answer.

    Now, if while traversing the array:

    the current number is already stored in any of the three variables, it means we will not use it again.
    the current number is greater than firstMax, then, the current number will become the largest of all numbers and firstMax will become the second largest, and secondMax will become the third largest number.
    the current number is not greater than firstMax but greater than secondMax, then, the current number will become the second largest, and secondMax will become the third largest number.
    the current number is smaller than firstMax and secondMax, but greater than thirdMax, then, the current number will become the third largest number.
    the current number is smaller than all three, then it will have no effect on those three variables.
    So, while traversing the array we update these three variables based on the current number.


    Algorithm
    Initialize variables:

    firstMax, secondMax, and thirdMax, to a value less than the minimum possible integer in the array.
    Iterate on all numbers of the nums array:

    If the current number is already stored in any of three variables we will skip this number.
    If the current number is greater than, firstMax, update all three variables.
    Otherwise, if the current number if greater than, secondMax, update secondMax and thirdMax.
    Otherwise, if the current number if greater than, thirdMax, update thirdMax.
    If thirdMax still has the initial value it means we, never had three distinct numbers, return firstMax, the largest number.

    Otherwise, return the third largest number, thirdMax.
     */
    // Best Practice
    // 1 ms
    public static int thirdMax(int[] nums) {

        long firstMax = Long.MIN_VALUE;
        long secondMax = Long.MIN_VALUE;
        long thirdMax = Long.MIN_VALUE;

        for (int num : nums) {
            if (firstMax == num || secondMax == num || thirdMax == num) {
                continue;
            }

            if (num > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = num;
            } else if (num > secondMax) {
                thirdMax = secondMax;
                secondMax = num;
            } else if (num > thirdMax) {
                thirdMax = num;
            }
        }

        if (thirdMax == Long.MIN_VALUE) {
            thirdMax = firstMax;
        }

        return (int) thirdMax;
    }


    // Main
    public static void main(String[] args) {

        int[] nums = new int[]{3, 2, 1};
        int thirdMax = thirdMax(nums);
        System.out.println("Output: " + thirdMax);
    }
}