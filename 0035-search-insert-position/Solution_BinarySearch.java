
public class Solution_BinarySearch {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 情况1：找到目标值，直接返回索引
            if (nums[mid] == target) {
                return mid;
            }
            // 情况2：中间值小于目标值，说明目标在右侧，缩小左边界
            else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
