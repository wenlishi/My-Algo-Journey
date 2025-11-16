import java.util.HashSet;
import java.util.Set;

public class Solution_HashSet {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (nums == null || n == 0) {
            return 0;
        }
        // 使用HashSet存储数组中的所有元素
        Set<Integer> set = new HashSet<>();
        // 将数组中的元素存入HashSet中
        for (int num : nums) {
            set.add(num);
        }
        // 记录最长连续序列的长度
        int maxLength = 0;
        // 遍历HashSet中的每一个元素
        for (int num : set) {
            // 从连续序列的起点开始进行检查
            // 即当前数字num的前一个数字不在集合中时
            if (!set.contains(num - 1)) {
                int currentLength = 1;
                int currentNum = num;
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }
                // 更新最长连续序列的长度
                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }
}
