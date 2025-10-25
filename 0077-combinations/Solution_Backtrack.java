import java.util.ArrayList;
import java.util.List;

public class Solution_Backtrack {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int[] nums = new int[n];
        int start = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        backtrack(res, nums, k, path, start);
        return res;
    }

    public void backtrack(List<List<Integer>> res, int[] nums, int k, List<Integer> path, int start) {
        if (path.size() == k) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(res, nums, k, path, i + 1);
            path.remove(path.size() - 1);
        }
    }
}

