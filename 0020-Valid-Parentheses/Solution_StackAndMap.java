import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Solution_StackAndMap {
    public boolean isValid(String s) {
        // 如果字符串长度为奇数，那么必然有一个括号无法匹配，直接返回错误
        // 这是一个快速失败的策略，可以提前结束无效的输入
        if (s.length() % 2 == 1) {
            return false;
        }
         // 创建一个哈希表来存储所有括号的配对关系。
        // Key 是右括号，Value 是左括号，这样方便我们在遇到右括号时，快速查找到它对应的左括号。
        // 使用 Map.of() 创建一个简洁、不可变的映射关系
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');   

        // Deque 是双端队列，但常被用作栈（比 Stack 类性能更好）
        Deque<Character> stack = new ArrayDeque<>();
        // 遍历字符串中的每一个字符,这里注意字符串要转成字符数组
        for (char c : s.toCharArray()) {
             // 判断当前字符是否是左括号。
            if (c == '(' || c == '[' || c == '{') {
                // 如果是左括号，将其压入栈
                stack.push(c);
            } else {
                // // 这是核心的匹配逻辑，包含两个关键检查：
                // 1. stack.isEmpty(): 在尝试匹配右括号时，栈是否已经为空？
                //    如果为空，说明这个右括号没有对应的左括号，例如 s = "])"。
                // 2. stack.pop() != map.get(c): 如果栈不为空，弹出栈顶的左括号，
                //    并检查它是否与当前右括号在 map 中对应的左括号相等。
                //    如果不相等，说明括号类型不匹配，例如 s = "([)]"。
                //
                // 注意：因为 || (或) 操作符的短路特性，只有当 stack.isEmpty() 为 false 时，
                // 右边的 stack.pop() 才会被执行，这完美地避免了对空栈执行 pop 操作的风险。
                if (stack.isEmpty() || stack.pop() != map.get(c)) {
                    return false;
                }

            }
        }
        // 当循环结束后，我们需要检查栈的状态。
        // 如果栈中还有剩余的元素（左括号），说明这些左括号没有被对应的右括号闭合，
        // 例如 s = "([{"。因此，字符串是无效的。
        return stack.isEmpty();
        
    }
    // --- 以下是测试部分 ---
    public static void main(String[] args) {
        // 1. 创建 Solution 类的实例
        Solution_StackAndMap solution = new Solution_StackAndMap();

        // 2. 定义一些测试用例
        String test1 = "()";           // 期望: true
        String test2 = "()[]{}";       // 期望: true
        String test3 = "(]";            // 期望: false
        String test4 = "([)]";          // 期望: false
        String test5 = "{[]}";         // 期望: true
        String test6 = "]";            // 期望: false
        String test7 = "";             // 期望: true (空字符串是有效的)

        // 3. 运行测试并打印结果
        System.out.println("测试用例 1 '()': " + solution.isValid(test1));
        System.out.println("测试用例 2 '()[]{}': " + solution.isValid(test2));
        System.out.println("测试用例 3 '(]': " + solution.isValid(test3));
        System.out.println("测试用例 4 '([)]': " + solution.isValid(test4));
        System.out.println("测试用例 5 '{[]}': " + solution.isValid(test5));
        System.out.println("测试用例 6 ']': " + solution.isValid(test6));
        System.out.println("测试用例 7 (空字符串): " + solution.isValid(test7));
    }
}
