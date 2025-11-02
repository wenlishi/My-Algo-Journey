

public class Solution_Simulation {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] mat = new int[m][n];
        int[][] protect = new int[m][n];
        
        // 标记守卫,守卫标记为1
        for (int[] guard : guards) {
            mat[guard[0]][guard[1]] = 1; 
        }
        // 标记墙，墙标记为2
        for (int[] wall : walls) {
            mat[wall[0]][wall[1]] = 2;
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 遍历到守卫
                if (mat[i][j] == 1) {
                    markGuardedCells(protect, mat, i, j);
                }
            }
        }
        // 计算未被守卫保护的单元格数量
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (protect[i][j] == 0) {
                    count++;
                }
            }
        }
        return count - guards.length - walls.length;
    }

    // 标记守卫保护的单元格
    public void markGuardedCells(int[][] protect, int[][] mat, int row, int col) {
        int m = mat.length;
        int n = mat[0].length;
        // 四个方向
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        // 遍历四个方向
        for (int[] dir : directions) {
            int r = row + dir[0];
            int c = col + dir[1]; 
            // 一直向该方向走，直到遇到墙或守卫
            while (r >= 0 && r < m && c >= 0 && c < n && mat[r][c] != 2 && mat[r][c] != 1) {
                protect[r][c] = 1;
                r += dir[0];
                c += dir[1];
            }
        }
        // 下边
        // for (int i = row + 1; i < m; i++) {
        //     if (mat[i][col] == 2 || mat[i][col] == 1) {
        //         break;
        //     }
        //     protect[i][col] = 1;
        // }
        // // 右边
        // for (int i = col + 1; i < n; i++) {
        //     if (mat[row][i] == 2 || mat[row][i] == 1) {
        //         break;
        //     }
        //     protect[row][i] = 1;
        // }
        // // 上面
        // for (int i = row - 1; i >= 0; i--) {
        //     if (mat[i][col] == 1 || mat[i][col] == 2) {
        //         break;
        //     }
        //     protect[i][col] = 1;
        // }
        // // 左边
        // for (int i = col - 1; i >= 0; i--) {
        //     if (mat[row][i] == 2 || mat[row][i] == 1) {
        //         break;
        //     }
        //     protect[row][i] = 1;
        // }

    }
}
