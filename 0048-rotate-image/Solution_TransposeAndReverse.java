public class Solution_TransposeAndReverse {
    public void rotate(int[][] matrix) {
        // 先进行转置操作,即沿主对角线交换元素(左上-右下对角线)
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 再进行水平(左右)翻转操作
        // for (int i = 0; i < matrix.length; i++) {
        //     int border = matrix[0].length / 2;
        //     // 翻转每一行
        //     for (int j = 0; j < border; j++) {
        //         int temp = matrix[i][j];
        //         matrix[i][j] = matrix[i][matrix.length - 1 - j];
        //         matrix[i][matrix.length - 1 - j] = temp;
        //     }

        // }

        for (int i = 0; i < matrix.length; i++) {
            int left = 0;
            int right = matrix[0].length - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--; 
            }
        }

    }
}