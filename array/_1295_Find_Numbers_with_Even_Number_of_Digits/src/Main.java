/**
 * 1295. Find Numbers with Even Number of Digits
 * <p>
 * Given an array nums of integers, return how many of them contain an even number of digits.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [12,345,2,6,7896]
 * Output: 2
 * Explanation:
 * 12 contains 2 digits (even number of digits).
 * 345 contains 3 digits (odd number of digits).
 * 2 contains 1 digit (odd number of digits).
 * 6 contains 1 digit (odd number of digits).
 * 7896 contains 4 digits (even number of digits).
 * Therefore only 12 and 7896 contain an even number of digits.
 * Example 2:
 * <p>
 * Input: nums = [555,901,482,1771]
 * Output: 1
 * Explanation:
 * Only 1771 contains an even number of digits.
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 500
 * 1 <= nums[i] <= 105
 */
public class Main {
    public static void main(String[] args) {

        int[] num1 = {12, 345, 2, 6, 7896};

        int answer1 = findNumbers(num1);

        System.out.println("count: " + answer1);

        int[] num2 = {555, 901, 482, 1771};

        int answer2 = findNumbers(num2);

        System.out.println("count: " + answer2);

        int answer3 = findNumber(num2);

        System.out.println("count: " + answer3);
    }

    public static int findNumbers(int[] nums) {
        int count = 0;                            // Solution variable initialised to 0
        for (int n : nums)                       // Iterate over each number
            if (getNumberOfDigits(n) % 2 == 0)   // Call getNumberOfDigits which return the total number of digits in the number
                count++;                          // if even number of digits are returned we increment count by 1
        return count;
    }

    public static int getNumberOfDigits(int num) {
        int digit = 0;                          // Initialise digit to 1, not 0 cause we are dividing num/10 in while loop
        while (num != 0) {                 // Iterate until number is 0; X/=Y it is same as X=X/Y
            digit++;                            // Increment digit until number is 0
            num = num / 10;

        }
        return digit;
    }

    /**
     * 2 ms, 43.9 MB
     */
    public static int findNumber(int[] nums) {
        int count = 0;                            // Solution variable initialised to 0
        for (int num : nums) {                 // Iterate over each number
            int digit = 0;
            while (num > 0) {                 // Iterate until number is 0; X/=Y it is same as X=X/Y
                digit++;                            // Increment count until number is 0
                num /= 10;
            }
            if (digit % 2 == 0)   // Call getNumberOfDigits which return the total number of digits in the number
                count++;                          // if even number of digits are returned we increment count by 1
        }
        return count;
    }

    /**
     * 1 ms, 41.8 MB
     */
    public int findNumberss(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length; i++) {

            if(String.valueOf(nums[i]).length()%2 == 0){
                count++;
            }
        }
        return count;
    }
}