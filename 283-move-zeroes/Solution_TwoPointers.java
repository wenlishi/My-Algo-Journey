public class Solution_TwoPointers {
    public void moveZeroes(int[] nums) {
        // 设定两个快慢指针
        int slow = 0;
        int fast = 0;
        // 通过快指针遍历数组
        while (fast < nums.length) {
            // 当快指针指向的元素不为0时，将其赋值给慢指针位置，并移动慢指针
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        // 将慢指针之后的位置全部赋值为0
        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
