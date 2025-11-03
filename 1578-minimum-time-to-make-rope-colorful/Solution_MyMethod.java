public class Solution_MyMethod {
    public int minCost(String colors, int[] neededTime) {
        int time = 0;
        int maxTime = neededTime[0];
        for (int i = 1; i < colors.length(); i++) {
            // 遍历到重复颜色气球
            if (colors.charAt(i) == colors.charAt(i - 1)) {
                time += Math.min(neededTime[i], maxTime);
                maxTime = Math.max(neededTime[i], maxTime);
                // 遍历到不同颜色的气球的时候，将maxTime更新当前颜色的气球用时
            } else {
                maxTime = neededTime[i];
            }
        }
        return time;

    }
}
