public class Solution_MyMethod {
    public boolean isValidSudoku(char[][] board) {
        // 三个二维数组分别用于记录每一列和每一个九宫格中数字的出现情况
        boolean[][] colCheck = new boolean[9][9];
        boolean[][] boxCheck = new boolean[9][9];
        // 遍历每一行
        for (int i = 0; i < 9; i++) {
            // 记录每一行中数字的出现情况
            boolean[] rowCheck = new boolean[9];
            // 遍历每一列
            for (int j = 0; j < 9; j++) {
                // 只检查非空格子
                if (board[i][j] != '.') {
                    // 行检查
                    int num = board[i][j] - '1';
                    // 九宫格检查
                    // 计算九宫格的索引
                    int index = (i / 3) * 3 + j / 3;
                    if (rowCheck[num] || colCheck[j][num] || boxCheck[index][num]) {
                        return false;
                    }
                     // 若不存在，则同时标记到三个记录中
                    rowCheck[num] = true;
                    colCheck[j][num] = true;
                    boxCheck[index][num] = true;

                }
            }
        }
        return true;
    }
}
