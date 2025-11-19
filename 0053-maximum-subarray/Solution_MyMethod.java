public class Solution_MyMethod {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        // 注意：如果 N 很大，这个二维数组会造成 "Memory Limit Exceeded" (内存溢出)
        int[][] dp = new int[n][n];
        
        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) { // 关键点：j 从 i 开始，只计算上半三角
                if (i == j) {
                    dp[i][j] = nums[i];
                } else {
                    dp[i][j] = dp[i][j - 1] + nums[j];
                }
                // 一边计算一边更新最大值，不需要最后再跑两个循环
                maxValue = Math.max(maxValue, dp[i][j]);
            }
        }
        return maxValue; 
    }
}