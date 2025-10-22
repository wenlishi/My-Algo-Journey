import java.util.Deque;
import java.util.LinkedList;

public class Solution_Bfs {
    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int n = nums.length;
        Deque<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        // 1. 初始化
        queue.offer(0);
        visited[0] = true;
        int jumps = 0; // 当前的跳跃次数 (层数)
        // 4. 开始分层循环
        while (!queue.isEmpty()) {
            // a. 锁定当前层的节点数
            int levelSize = queue.size();
            // b. 遍历当前层
            for (int i = 0; i < levelSize; i++) {
                // i. 取出当前节点
                int currIndex = queue.poll();
                // ii. (优化：在poll时检查不如在add时检查，但这里也行)
                // 在这个特定问题中，我们其实可以在"探索邻居"时就检查终点
                // iii. 探索邻居
                int maxJump = nums[currIndex];
                for (int j = 1; j <= maxJump; j++) {
                    int nextIndex = currIndex + j;
                    // 检查是否到达终点
                    if (nextIndex == n - 1) {
                        // 找到了！因为是BFS，第一次找到时
                        // jumps 代表当前层，我们还需要 1 跳才能到
                        return jumps + 1; 
                    }
                    // 检查越界
                    if (nextIndex >= n) {
                        break; // 后面的更远，都越界了
                    }
                    // v. 如果未被访问
                    if (!visited[nextIndex]) {
                        visited[nextIndex] = true;
                        queue.offer(nextIndex);
                    }
                }
            }
            // d. 当前层处理完毕，跳数+1
            jumps++;
        }
        return jumps; // 理论上根据题意不会执行到这里
    }
}
