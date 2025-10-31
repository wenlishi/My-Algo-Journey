

public class Solution_MyMethod {
    public int[] getSneakyNumbers(int[] nums) {
        // int N = nums.length;
        // int[] res = new int[2];
        // int index = 0;

        // for (int i = 0; i < N; i++) {
        //     // 1. 获取原始值（索引）
        //     //    nums[i] 可能已经被加过 N，所以我们用 % N 来
        //     int indexToMark = nums[i] % N;
        //     nums[indexToMark] += N;

        //     // 3. (可选的优化) 可以在标记时就找出重复
        //     //    如果我们第二次给 nums[indexToMark] 加上 N，
        //     //    (nums[indexToMark] / N) 会从 1 变为 2。
        //     if (nums[indexToMark] / N == 2) {
        //         res[index] = indexToMark;
        //         index++;
        //     }
        // }

        // return res;

        int N = nums.length;
        int[] res = new int[2];

        int index = 0;
        for (int i = 0; i < N; i++) {
            int indexToMark = nums[i] % N;
            nums[indexToMark] += N;
            if (nums[indexToMark] / N == 2) {
                res[index++] = indexToMark;
            }
        }
        return res;
    }
}
