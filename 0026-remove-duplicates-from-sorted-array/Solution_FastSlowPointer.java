public class Solution_FastSlowPointer {
    public int removeDuplicates(int[] nums) {
        // 使用快慢指针
        // 指针初始为1，因为每次比较当前元素和前一个元素是否相等
        int fast = 1;
        int slow = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[fast] != nums[fast - 1]) {

                nums[slow] = nums[fast]; 
                slow ++;
            }
            fast ++;
        }
        return slow;
    }
    
}
