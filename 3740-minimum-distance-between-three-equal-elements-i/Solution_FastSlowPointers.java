public class Solution_FastSlowPointers {
     public int minimumDistance(int[] nums) {
        int dis = Integer.MAX_VALUE;
        int slow = 0;
        while (slow < nums.length - 2) {
            int fast = slow;
            int count = 0;
            while (fast < nums.length && count < 3) {
                if (nums[fast] == nums[slow]) {
                    count++;
                }
                fast++;
            }
            if (count == 3) {
                dis = Math.min(dis, 2 * (fast - 1 - slow));
            }
            slow++;
        }
        if (dis == Integer.MAX_VALUE) {
            return -1;
        }
        return dis;
    }
}
