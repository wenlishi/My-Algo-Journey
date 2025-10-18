import java.util.ArrayList;
import java.util.List;

public class Solution_Recursion {

    /**
     * 主方法：生成 n 对括号的所有有效组合。
     * @param n 括号的对数
     * @return 包含所有有效括号组合的列表
     */
    public List<String> generateParenthesis(int n) {
        // 初始化列表，用于存储所有有效的括号组合
        List<String> combinations = new ArrayList<>();
        // 调用递归函数，从空字符数组和位置0开始生成
        // 字符数组长度为 2*n，因为每对括号有两个字符
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    /**
     * 递归函数：生成所有可能的括号排列（包括无效的）。
     * 采用深度优先搜索（DFS）回溯策略。
     * @param current 当前正在构建的字符数组，代表一个括号组合
     * @param pos 当前要填充的位置索引
     * @param combinations 用于存储所有有效结果的列表
     */
    public void generateAll(char[] current, int pos, List<String> combinations) {
        // 递归终止条件：当当前位置 pos 已经填满了整个数组长度时
        if (pos == current.length) {
            // 检查当前生成的括号组合是否有效
            if (valid(current)) {
                // 如果有效，则将字符数组转换为String并加入结果列表
                combinations.add(new String(current)); // 注意：这里使用 new String(current) 是正确的
            }
            // 如果无效，则直接丢弃这个组合，回溯尝试其他可能
        } else {
            // 在当前 pos 位置尝试放入左括号 '('
            current[pos] = '(';
            // 递归调用，处理下一个位置 (pos+1)
            generateAll(current, pos + 1, combinations);
            // 当前 pos 位置尝试放入右括号 ')'，这里不是追加，而是直接覆盖
            current[pos] = ')';
            // 递归调用，处理下一个位置 (pos+1)
            generateAll(current, pos + 1, combinations);
            // 注意：这里没有显式的“撤销”操作（如将current[pos]置空），
            // 因为递归调用是基于数组的同一份引用，下一次赋值会直接覆盖上一次的值。
            // 这种利用递归栈和数组引用覆盖的方式，是回溯的一种实现。
        }
    }

    /**
     * 验证函数：判断一个括号组合是否有效。
     * 有效的标准：
     * 1. 在遍历过程中，任意时刻右括号 ')' 的数量不能超过左括号 '(' 的数量（即balance不能为负）。
     * 2. 遍历结束时，左括号和右括号的数量必须相等（即balance为0）。
     * @param current 待验证的括号组合字符数组
     * @return 如果组合有效返回 true，否则返回 false
     */
    public boolean valid(char[] current) {
        int balance = 0; // 平衡因子，遇到'('加1，遇到')'减1
        for (char c : current) {
            if (c == '(') {
                balance++; // 遇到左括号，平衡因子加1
            } else {
                balance--; // 遇到右括号，平衡因子减1
            }
            // 关键检查：如果在遍历过程中平衡因子变为负数，说明有未匹配的右括号，组合无效
            if (balance < 0) {
                return false;
            }
        }
        // 最终检查：遍历完成后，平衡因子必须恰好为0，表示所有括号都正确匹配
        return balance == 0;
    }
}