import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_Dfs {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    // dfs 深度遍历的迭代法,使用栈实现
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 创建栈
        Deque<TreeNode> stk = new ArrayDeque<>();
        // 将根结点入栈
        stk.push(root);
        // 当栈不为空持续循环
        while (!stk.isEmpty()) {
            // 弹出栈顶元素
            TreeNode node = stk.pop();
            // 如果当前结点存在左结点，入栈
            if (node.left != null) {
                stk.push(node.left);
            }
            if (node.right != null) {
                stk.push(node.right);
            }
            // 交换当前结点的左右结点
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;
    }
    
}
