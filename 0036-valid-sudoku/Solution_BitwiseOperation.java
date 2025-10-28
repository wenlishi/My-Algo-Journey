
public class Solution_BitwiseOperation {
    public boolean isValidSudoku(char[][] board) {
        // 使用一维数组，每个整数记录一行/一列/一宫的数字出现情况
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] boxes = new int[9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    // 1. 计算数字对应的位掩码 (bitmask)，例如数字3对应 1 << 2 (二进制：0000 0100)
                    int bit = 1 << (board[i][j] - '1');
                    // 2. 计算九宫格索引
                    int boxIndex = (i / 3) * 3 + j / 3;

                    // 3. 使用位与(&)操作检查是否已存在。如果结果不为0，说明该位已被标记，存在冲突。
                    if ((rows[i] & bit) != 0 || (cols[j] & bit) != 0 || (boxes[boxIndex] & bit) != 0) {
                        return false;
                    }

                    // 4. 使用位或(|)操作将当前数字的位标记到记录中
                    rows[i] |= bit;
                    cols[j] |= bit;
                    boxes[boxIndex] |= bit;
                }
            }
        }
        return true;
    }
}
