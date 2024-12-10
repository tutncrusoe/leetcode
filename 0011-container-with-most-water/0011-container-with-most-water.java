class Solution {
    public static int maxArea(int[] height) {
        int head = 0;
        int tail = height.length - 1;
        int maxArea = 0;
        while (head < tail) {
            if (height[head] <= height[tail]) {
                maxArea = Math.max(maxArea, (height[head] * (tail - head)));
                System.out.println(maxArea);
                head++;
            } else if (height[head] > height[tail]) {
                maxArea = Math.max(maxArea, (height[tail] * (tail - head)));
                System.out.println(maxArea);
                tail--;
            }
            System.out.println("head: " + head + " tail: " + tail);
        }
        return maxArea;
    }
}