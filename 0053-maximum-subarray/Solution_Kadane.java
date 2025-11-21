public class Solution_Kadane {
    public int maxSubArray(int[] nums) {
        int n = nums.length;

        int currentSum = nums[0];
        int maxValue = nums[0];

        for (int i = 1; i < n; i++) {
            // 如果 currentSum 为负数，则舍弃之前的子数组，从当前元素重新开始
            if (currentSum < 0) {
                currentSum = nums[i];
            } else {
                currentSum += nums[i];
            }
            maxValue = Math.max(maxValue, currentSum);
        }
        return maxValue;
    }
}
    