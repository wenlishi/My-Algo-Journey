import java.util.ArrayList;
import java.util.List;

public class Solution_SimulationByDirectionVectorRotation {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        // 方向向量，初始方向向右
        int dr = 0;
        int dc = 1;
        // 记录访问状态的数组
        boolean[][] isVisited = new boolean[m][n];
        int row = 0;
        int col = 0;

        for (int i = 0; i < m * n; i++) {
            res.add(matrix[row][col]);
            isVisited[row][col] = true;
            int nextrow = row + dr;
            int nextcol = col + dc;
            // 判断下一个位置是否越界或已访问
            if (nextcol < 0 || nextrow < 0 || nextcol >= n || nextrow >= m || isVisited[nextrow][nextcol]) {
                // 旋转方向向量：右->下->左->上,这个等价于乘于一个90度旋转矩阵，然后达到顺时针旋转的效果
                int old_dr = dr;
                dr = dc;
                dc = -old_dr;
            }
            col+= dc;
            row+= dr;

        }
        return res;

        
    }
}
