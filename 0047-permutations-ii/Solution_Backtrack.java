import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_Backtrack {
    public List<List<Integer>> permuteUnique(int[] nums) {
        // 存储所有的排列结果
        List<List<Integer>> res = new ArrayList<>();
        // 特殊情况处理
        if (nums.length == 0) {
            return res;
        }
        // 存储当前生成的排列路径
        List<Integer> path = new ArrayList<>();
        // 标记数组，记录每个元素是否被使用
        boolean[] used = new boolean[nums.length];
        // 对数组进行排序，便于后续的剪枝操作
        Arrays.sort(nums);
        // 开始回溯搜索
        backtrack(path, res, nums, used, 0);
        return res; 
        
    }
    public void backtrack(List<Integer> path, List<List<Integer>> res, int[] nums, boolean[] used, int depth) {
        // 终止条件，当前的路径长度等于数组的长度，说明已经生成了一个完整的排列
        if (depth == nums.length) {
            // 将当前路径的拷贝添加到结果集（需要新建对象避免后续修改影响）
            res.add(new ArrayList<>(path));
            return;
        }
        // 遍历所有可能的元素，进行选择，每一次循环代表在当前层选择一个元素
        for (int i = 0; i < nums.length; i++) {
            // 跳过已经使用的元素，进行剪枝
            if (used[i]) {
                continue;
            }
            // 剪枝条件，跳过相同的元素，确保每个数字只在同一层使用一次
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            // 选择当前元素
            path.add(nums[i]);
            // 标记当前元素已经使用
            used[i] = true;
            // 递归进入下一层
            backtrack(path, res, nums, used, depth + 1);
            // 撤销选择，回溯
            used[i] = false;
            // 从路径中移除最后一个元素
            path.remove(path.size() - 1);

        }

    }
}
