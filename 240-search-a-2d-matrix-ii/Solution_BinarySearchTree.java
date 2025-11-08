import java.util.Arrays;

public class Solution_BinarySearchTree {
     public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        int col = n - 1;
        // 把矩阵的右上角看成是根结点，整个矩阵可以看作一棵二叉搜索树
        while (col >= 0 && row < m) {
            if (matrix[row][col] == target) {
                return true;
            // 如果当前值大于目标值，说明目标值在当前值的左边，列索引减一,相当于在二叉搜索树中往左子树走
            } else if (matrix[row][col] > target) {
                col--;
            // 如果当前值小于目标值，说明目标值在当前值的下边，行索引加一,相当于在二叉搜索树中往右子树走
            } else {
                row++;
            }

        }
        return false;
    }

        
}
