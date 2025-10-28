import java.util.ArrayList;
import java.util.List;

public class Solution_Backtrack {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int current_sum = 0;
        int start = 0;
        backtrack(target, candidates ,current_sum, start, res, path);
        return res;
    }
    public void backtrack(int target, int[] candidates,int current_sum, int start, List<List<Integer>> res, List<Integer> path) {
        // 如果当前和等于目标值，加入结果集
        if (current_sum == target) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        // 如果当前和超过目标值，直接返回，剪枝
        if (current_sum > target) {
            return;
        }
        // 遍历候选数组,注意这里的start参数，避免重复使用前面的元素，但是可以重复使用当前元素
        for (int i = start; i < candidates.length; i++) {
            path.add(candidates[i]);
            backtrack(target, candidates, current_sum + candidates[i], i, res, path);
            path.remove(path.size() - 1);
        }

    }
}
