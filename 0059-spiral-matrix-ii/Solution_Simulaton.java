public class Solution_Simulation {
    public int[][] generateMatrix(int n) {
        //定义初始方向
        int dr = 0;
        int dc = 1;
        int[][] mat = new int[n][n];
        int start = 1;
        // 初始化位置
        int row = 0;
        int col = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++){
                mat[row][col] = start;
                
                // 计算下一个位置
                int nextrow = row + dr;
                int nextcol = col + dc;
                if (nextrow < 0 || nextcol < 0 || nextrow > n - 1 || nextcol > n - 1 || mat[nextrow][nextcol] != 0) {
                    // 当下一位置为边界或者是已经访问的位置转向
                    int temp = dr;
                    dr = dc;
                    dc = -temp;
                    
                }
                row += dr;
                col += dc;
                start++;
                
            }
        }
        return mat;
    
    }

}