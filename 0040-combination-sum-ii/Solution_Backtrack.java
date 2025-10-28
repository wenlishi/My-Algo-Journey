import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_Backtrack {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int start = 0;
        int current_sum = 0;
        // 先对数组进行排序，方便后续去重
        Arrays.sort(candidates);
        backtrack(res, path, current_sum, start, target, candidates);
        return res;

    }
    public void backtrack(List<List<Integer>> res, List<Integer> path, int current_sum, int start, int target, int[] candidates){
        if (current_sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (current_sum > target) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            // 去重逻辑：跳过与上一个元素相同的元素
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.add(candidates[i]);
            backtrack(res, path, current_sum + candidates[i], i + 1, target, candidates);
            path.remove(path.size() - 1);

        }
    }
}
