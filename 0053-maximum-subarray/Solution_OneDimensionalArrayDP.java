public class Solution_One {
    public int maxSubArray(int[] nums) {

        int n = nums.length;

        // dp[i]的含义是，以dp[i]结尾的最大的字数组和
        int[] dp = new int[n];
        // 初始化dp[0]
        dp[0] = nums[0];
        // 记录最大值,初始值为dp[0]
        int maxValue = dp[0];
        for (int i = 1; i < n; i++) {
            // 状态转移方程,dp[i] = max(dp[i-1] + nums[i], nums[i]), 核心思想是看前面的和是否为正, 如果为正则加上当前值,否则重新开始
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            maxValue = Math.max(dp[i], maxValue);
        }
        return maxValue;

    }
}