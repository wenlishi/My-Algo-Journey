public class Solution_Backtrack {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean used = new boolean[nums.length];
        if (nums.length == 0) {
            return res;
        }
        backtrack(path, res, nums, used, 0);
        return res;
    }
    public void backtrack(List<Integer> path, List<List<Integer>> res, int[] nums, boolean[] used, int depth) {
        if (depth == nums.length) {
            res.add(new ArrayLsit<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                backtrack(path, res, nums, used, depth + 1);
                used[i] = false;
                path.remove(path.size() - 1);

            }
        }
    }
}