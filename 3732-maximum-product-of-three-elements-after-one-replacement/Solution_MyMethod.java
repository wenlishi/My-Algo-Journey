public class Solution_MyMethod {
    public long maxProduct(int[] nums) {
        int firstMax = nums[0];
        int secondMax = nums[1];
        if (Math.abs(secondMax) > Math.abs(firstMax)) {
            int temp = firstMax;
            firstMax = secondMax;
            secondMax = temp;    
        }

        for (int i = 2; i < nums.length; i++) {
            int current = nums[i];
            int abscurrent = Math.abs(current);
            int absFirst = Math.abs(firstMax);
            int absSecond = Math.abs(secondMax);
            // 当前元素绝对值大于最大值，更新两个值
            if (abscurrent > absFirst) {
                secondMax = firstMax;
                firstMax = current;
                // 当前元素大于第二大值，更新第二大值
            } else if (abscurrent > absSecond) {
                secondMax = current;
            } 

        }
        if (firstMax > 0 && secondMax > 0 || firstMax < 0 && secondMax < 0) {
            return (long) firstMax * secondMax * 100000L;
        }
        return -(long) firstMax * secondMax * 100000L;
    }
}