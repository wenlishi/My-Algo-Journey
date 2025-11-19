public class Solution_PrefixSumGreedy {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        int min = 0; // 记录“之前出现过的最小前缀和”
        int sum = 0; // 记录“当前的前缀和”
        // 遍历每一个位置作为“当前前缀和”的结尾,计算以该位置结尾的最大子数组和
        // 可以把这个想象成股票买卖问题，sum是当前价格，min是之前的最低价格，ans是最大利润
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            ans = Math.max(ans, sum - min);
            min = Math.min(min, sum);
        }
        return ans;

    }
}