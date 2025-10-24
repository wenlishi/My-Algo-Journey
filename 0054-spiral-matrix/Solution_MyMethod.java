public class Solution_MyMethod {
    public List<Integer> spiralOrder(int[][] matrix) {
        // 存储方向：右，下，左，上
        int[] directions = new int[] {0,1,2,3};
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] isVisited = new boolean[m][n];
        List<Integer> res = new ArrayList<>();
        int row = 0;
        int col = 0;
        int current = matrix[0][0];
        res.add(current);
        isVisited[row][col] = true;
        // 存储方向的序号
        int index = 0;
        for (int i = 1; i < m * n; i++) {
            if (index % 4 == 0) {
                if (col >= n - 1 || isVisited[row][col + 1]) {
                    index++;
                    row++;
                    current = matrix[row][col];
                    isVisited[row][col] = true;
                    res.add(current);
                    continue;
                }
                col++;
                current = matrix[row][col];
                res.add(current);
                isVisited[row][col] = true;
                
            } else if (index % 4 == 1) {
                if (row >= m - 1 || isVisited[row + 1][col]) {
                    index++;
                    col--;
                    current = matrix[row][col];
                    isVisited[row][col] = true;
                    res.add(current);
                    continue;
                }
                row++;
                current = matrix[row][col];
                res.add(current);
                isVisited[row][col] = true;
                
            } else if (index % 4 == 2) {
                if (col <= 0 || isVisited[row][col - 1]) {
                    index++;
                    row--;
                    current = matrix[row][col];
                    isVisited[row][col] = true;
                    res.add(current);
                    continue;
                }
                col--;
                current = matrix[row][col];
                res.add(current);
                isVisited[row][col] = true;
                
            } else {
                if (row <= 0 || isVisited[row - 1][col]) {
                    index++;
                    col++;
                    current = matrix[row][col];
                    isVisited[row][col] = true;
                    res.add(current);
                    continue;
                }
                row--;
                current = matrix[row][col];
                res.add(current);
                isVisited[row][col] = true;
               
            }
        }
        return res;
        
    }
}