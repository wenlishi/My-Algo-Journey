import java.util.ArrayList;
import java.util.List;

public class Solution_PruningBacktrack {
    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<>();
        backtrack(combinations, new StringBuilder(), 0, 0, n);
        return combinations;
    }
    public void backtrack(List<String> combinations, StringBuilder current, int left, int right, int max) {
        // 终止条件：当当前字符串长度达到2 * max（左右括号总数）
        if (current.length() == 2 * max) {
            combinations.add(current.toString());
            return;
        }
        // 条件一：左括号数量未达到目标值
        if (left < max) {
            current.append('(');
            // 递归：左括号数量加一，继续构建
            backtrack(combinations, current, left + 1, right, max);
            // 回溯：移除最后添加的字符（撤销选择）
            current.deleteCharAt(current.length() - 1);

        }
        // 条件二：右括号数量少于左括号数量（保证有效性）
        if (right < left) {
            current.append(')');
            backtrack(combinations, current, left, right + 1, max);
            // 这里回溯，因为StringBuilder可以追加，所以需要显式撤销状态
            current.deleteCharAt(current.length() - 1);
        }

    }


    public static void main(String[] args) {
        // 1. 创建解法类的实例
        Solution_PruningBacktrack solution = new Solution_PruningBacktrack();

        System.out.println("--- 开始测试括号生成算法 ---");
        
        // --- 测试用例 1: n = 3 ---
        int n1 = 3;
        System.out.println("\n输入: n = " + n1);
        // 调用方法获取结果
        List<String> result1 = solution.generateParenthesis(n1);
        // 打印结果
        System.out.println("输出: " + result1);
        
        // --- 测试用例 2: n = 1 ---
        int n2 = 1;
        System.out.println("\n输入: n = " + n2);
        List<String> result2 = solution.generateParenthesis(n2);
        System.out.println("输出: " + result2);

        // --- 测试用例 3: n = 4 ---
        int n3 = 4;
        System.out.println("\n输入: n = " + n3);
        List<String> result3 = solution.generateParenthesis(n3);
        System.out.println("输出: " + result3);

        System.out.println("\n--- 测试结束 ---");
    }
    
}
