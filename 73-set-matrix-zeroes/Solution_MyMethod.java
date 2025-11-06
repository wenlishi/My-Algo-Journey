 public class Solution_MyMethod {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] visited = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == 0 && matrix[i][j] == 0) {
                    traversal(i, j, matrix, visited);
                }
            }
        }
       
    }
    public void traversal(int row, int col, int[][] matrix, int[][] visited) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir : directions) {
            int i = row;
            int j = col;
            i += dir[0];
            j += dir[1];
            while (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length) {
                if (matrix[i][j] != 0) {
                    matrix[i][j] = 0;
                    visited[i][j] = 1;
                }
                
                i += dir[0];
                j += dir[1];
                
            }
        }

    }
}