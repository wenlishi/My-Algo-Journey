import java.util.ArrayList;
import java.util.List;

public class Solution_Backtrack {
    public List<List<Integer>> permute(int[] nums) {
        // 存储所有的排列的结果
        List<List<Integer>> res = new ArrayList<>();
        // 存储当前生成的排列的路径
        List<Integer> path = new ArrayList<>();
        // 标记数组，记录每个元素是否被使用
        boolean[] used = new boolean[nums.length];
        if (nums.length == 0) {
            return res;
        }
        // 开始回溯搜索
        backtrack(path, res, nums, used, 0);
        return res;
    }
    public void backtrack(List<Integer> path, List<List<Integer>> res, int[] nums, boolean[] used, int depth) {
        // 终止条件：当前的路径长度等于数组的长度，说明已经生成一个完整的排列
        if (depth == nums.length) {
            // 将当前路径的拷贝添加到结果集（需要新建对象避免后续修改影响）
            res.add(new ArrayList<>(path));
            return;
        }
        // 遍历所有可能的元素
        for (int i = 0; i < nums.length; i++) {
            // 如果当前元素未被选择
            if (!used[i]) {
                // 做选择：将当前元素加入路径
                path.add(nums[i]);
                // 将当前元素标记为已使用
                used[i] = true;
                backtrack(path, res, nums, used, depth + 1);
                // 撤销选择：回溯操作
                used[i] = false; // 恢复元素使用状态
                path.remove(path.size() - 1); // 从路径中移除最后一个元素

            }
        }
    }
}