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
        Deque<TreeNode> stk = new ArrayDeque<>();

        stk.push(root);
        while (!stk.isEmpty()) {
            TreeNode node = stk.pop();
            if (node.left != null) {
                stk.push(node.left);
            }
            if (node.right != null) {
                stk.push(node.right);
            }
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;
    }
    
}
