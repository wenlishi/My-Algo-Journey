import java.util.ArrayList;
import java.util.List;

public class Solution_MyMethod {
    public List<List<Integer>> generate(int numRows) {
        // 创建结果列表
        List<List<Integer>> res = new ArrayList<>();
        // 迭代生成每一行
        for (int i = 0; i < numRows; i++) {
            // 创建当前行的列表
            List<Integer> path = new ArrayList<>();
            // 填充当前行的元素
            for (int j = 0; j < i + 1 ; j++) {
                // 处理边界元素，第一个和最后一个元素为1
                if (j == 0 || j == i) {
                    path.add(1);
                } else {
                    // 非边界元素位上一行的相邻的两个元素之和
                    path.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }        
            }
            // 将当前行添加到结果列表中
            res.add(path);
        }
        return res;
    }
}
