class Solution {
    public int[] getConcatenation(int[] nums) {
        
        int[] ans = new int[2*nums.length];
        int right;

        for (int left = 0; left < nums.length; ++left) {
            right = left + nums.length;
            ans[left] = nums[left];
            ans[right] = nums[left];
        }

        return ans;
    }
}