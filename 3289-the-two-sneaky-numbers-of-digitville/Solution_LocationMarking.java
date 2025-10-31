

public class Solution_LocationMarking {
    public int[] getSneakyNumbers(int[] nums) {
        int N = nums.length;
        
        // 既然题目保证有两个重复，我们直接创建长度为2的数组
        int[] duplicates = new int[2];
        int foundCount = 0; // 一个计数器，用作 duplicates 数组的索引

        // === 阶段 1: 原地标记 ===
        // 遍历数组中的每一个元素
        for (int i = 0; i < N; i++) {
            // 1. 获取原始值（索引）
            //    nums[i] 可能已经被加过 N，所以我们用 % N 来获取它的原始值。
            //    这个原始值就是我们要去标记的“索引”。
            int indexToMark = nums[i] % N;

            // 2. 进行标记
            //    我们将 N 加到 nums[indexToMark] 上。
            nums[indexToMark] += N;

            // 3. (可选的优化) 可以在标记时就找出重复
            //    如果我们第二次给 nums[indexToMark] 加上 N，
            //    (nums[indexToMark] / N) 会从 1 变为 2。
            if (nums[indexToMark] / N == 2) {
                // 检查 foundCount 确保只添加两个数（尽管题目保证了）
                if (foundCount < 2) {
                    duplicates[foundCount] = indexToMark;
                    foundCount++;
                }
            }
        }

        // (在题目保证只有两个数各重复一次的条件下，foundCount 此时必为 2)
        if (foundCount == 2) {
            return duplicates;
        }

        // === 阶段 2: 收集结果 ===
        // (如果不在阶段1中收集，可以在这里单独收集)
        // 注意：在题目给定的约束下，阶段 1 总能找到答案，
        // 这个阶段 2 实际上是“不可达”的，但作为逻辑完整性保留。
        
        // 重新设置计数器
        foundCount = 0;
        int n = N - 2;
        for (int i = 0; i < n; i++) {
            // 如果这个索引位置被增加了两次 N 或更多次...
            if (nums[i] / N >= 2) {
                if (foundCount < 2) {
                    duplicates[foundCount] = i;
                    foundCount++;
                }
            }
        }

        return duplicates;
    }
}
