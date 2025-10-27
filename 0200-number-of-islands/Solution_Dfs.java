

public class Solution_Dfs {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 发现一个未被访问过的岛屿
                if (visited[i][j] == 0 && grid[i][j] == '1') {
                    // 深度优先搜索
                    dfs(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;
        
    }
    // 深度优先搜索
    public void dfs (char[][] grid ,int row, int col, int[][] visited) {
        // 越界
        if (row < 0 || col < 0 || row > grid.length - 1 || col > grid[0].length -1) {
            return;
        }
        // 水域或者已经访问过
        if (grid[row][col] == '0' || visited[row][col] == 1) {
            return;
        }
        // 标记为已访问
        visited[row][col] = 1;
        // 上下左右四个方向继续搜索
        dfs(grid, row - 1, col, visited);
        dfs(grid, row + 1, col, visited);
        dfs(grid, row, col - 1, visited);
        dfs(grid, row, col + 1, visited);

    }
}
