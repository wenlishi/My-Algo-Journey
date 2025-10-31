import java.util.Arrays;

public class Solution_Sort {
    public int[] getSneakyNumbers(int[] nums) {
        int [] res = new int[2];
        Arrays.sort(nums);
        int index = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                res[index++] = nums[i];
            }
        }
        return res;
    }
}
