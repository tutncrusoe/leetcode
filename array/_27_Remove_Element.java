public class _27_Remove_Element {
    public static void main(String[] args) {

        int[] nums = {3, 2, 2, 3};
        int val = 3;

        int count = removeElement(nums, val);
        System.out.println("result: " + count);

    }

    /**
     * Complexity analysis
     *
     * Time complexity : O(n). Assume the array has a total of nnn elements, both iii and jjj traverse at most 2n2n2n steps.
     *
     * Space complexity : O(1).
     */
    public static int removeElement(int[] nums, int val) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[count++] = nums[i];
            }
        }
        return count;
    }
}