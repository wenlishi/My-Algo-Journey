
public class Solution_Greedy {
    public int jump(int[] nums) {
        int jumps = 0;
        int currentEnd = 0;
        int maxReach = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            // 更新能到达的最远位置
            maxReach = Math.max(maxReach, nums[i] + i);
            // 如果已经可以到达最后位置，提前结束
            if (maxReach >= nums.length - 1) {
                return jumps + 1;
            }
            // 到达当前跳跃的边界，需要增加跳跃次数
            if (i == currentEnd) {
                jumps++;
                currentEnd = maxReach;
            }
        }
        return jumps;
    }
}
