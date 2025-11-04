import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_DfsAddBinarySearch {
    private static final List<Integer> BEAUTIFUL_NUM = new ArrayList<>();
    
    // 我们需要生成的数最大到 10^6 附近。
    // 包含 7 位数的最大平衡数是 1,224,444，所以 7 位的长度是足够的。
    private static final int MAX_LEN = 7; 

    /**
     * 静态初始化代码块。
     * 这段代码将在类第一次被 JVM 加载时自动执行，且只执行一次。
     * 它的作用等同于 Python 脚本在全局范围执行的 DFS。
     */
    static {
        // cnt 是一个频率计数器，索引 0-9 对应数字 0-9
        int[] cnt = new int[10];
        
        // 从 0 长度、数值 0 (空) 开始搜索
        dfs(0, 0, cnt);
        
        // DFS 生成的列表不一定是按数字大小排序的
        // (例如，"122" 可能会在 "333" 之前，但 "22" 可能会在 "122" 之后)
        // 我们必须先排序才能使用二分查找。
        Collections.sort(BEAUTIFUL_NUM);
    }

    /**
     * 辅助函数：深度优先搜索（DFS）来递归生成所有平衡数
     * * @param i   当前数字的长度（递归深度）
     * @param x   当前构建的数字值 (例如 1 -> 12 -> 122)
     * @param cnt 当前数字的频率统计数组
     */
    private static void dfs(int i, long x, int[] cnt) {
        // 基础情况：达到最大长度，停止递归
        if (i == MAX_LEN) {
            return;
        }

        // 确定下一个要尝试的数字 'k' 的起始值
        // 如果 i == 0（即第一位），k 从 1 开始（没有前导零）
        // 否则，k 从 0 开始
        int low = (i == 0) ? 1 : 0;

        for (int k = low; k < 10; k++) {
            
            // 剪枝条件（核心）：
            // 1. k == 0：根据定义，0 不能出现（因为它需要出现 0 次）
            // 2. cnt[k] >= k：数字 k 出现的次数已经达到 k 次，不能再多了
            if (k == 0 || cnt[k] >= k) {
                continue;
            }
            
            // 1. 选择（将数字 k 添加到当前数 x 的末尾）
            cnt[k]++;
            long newX = 10 * x + k;
            
            // 2. 检查当前 newX 是否 *本身* 就是一个平衡数
            if (isBeautiful(cnt)) {
                BEAUTIFUL_NUM.add((int) newX);
            }
            
            // 3. 递归（继续构建更长的数字）
            dfs(i + 1, newX, cnt);
            
            // 4. 撤销选择（回溯）
            cnt[k]--;
        }
    }

    /**
     * 辅助函数：检查当前的数字计数是否满足“平衡”条件
     * （即：所有出现的数字 j，其出现次数 cnt[j] == j）
     */
    private static boolean isBeautiful(int[] cnt) {
        // 1. 0 出现的次数必须为 0
        if (cnt[0] > 0) {
            return false;
        }
        
        boolean hasAtLeastOneDigit = false;
        // 2. 检查所有非零数字 (1 到 9)
        for (int j = 1; j < 10; j++) {
            if (cnt[j] > 0) { // 如果数字 j 存在...
                hasAtLeastOneDigit = true;
                if (cnt[j] != j) { // ...它的次数必须等于 j
                    // 例如，"12" (cnt[1]=1, cnt[2]=1) -> 失败，因为 cnt[2] != 2
                    return false;
                }
            }
        }
        // 必须至少有一个数字 (例如，空的 "" 不是平衡数)
        return hasAtLeastOneDigit; // 例如，"1" -> true, "22" -> true
    }


    /**
     * 2. 查询方法（即题目要求的主函数）
     * * 在预处理好的 BEAUTIFUL_NUM 列表中找到第一个大于 n 的数。
     */
    public int nextBeautifulNumber(int n) {
        
        // 使用 Java 内置的二分查找
        int j = Collections.binarySearch(BEAUTIFUL_NUM, n);
        
        int insertionIndex;

        if (j >= 0) {
            // 1. 找到了 (j >= 0)
            // `j` 是 n 在列表中的某个索引。
            // 我们需要的是 *第一个大于* n 的数，所以必须向后扫描，
            // 跳过所有可能存在的、等于 n 的重复项。
            
            insertionIndex = j;
            while (insertionIndex < BEAUTIFUL_NUM.size() && 
                   BEAUTIFUL_NUM.get(insertionIndex) == n) {
                insertionIndex++;
            }
            // 循环结束后，insertionIndex 就是第一个 > n 的元素的索引

        } else {
            // 2. 未找到 (j < 0)
            // Java 的实现在未找到时返回 -(insertionPoint) - 1
            // 我们需要的索引 (insertionPoint) = -j - 1
            insertionIndex = -j - 1;
        }

        // insertionIndex 现在的功能等同于 Python 的 `bisect_right` 的结果
        // 题目保证 n < 10^6，而我们生成的数包含 1,224,444，
        // 所以 insertionIndex 永远不会越界。
        return BEAUTIFUL_NUM.get(insertionIndex);
    }
}
