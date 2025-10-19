public class Solution_Interation {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stk = new LinkedList<>();

        while (root != null || !stk.isEmpty()) {
            // 1. 深度优先遍历左子树
            while (root != null) {
                stk.push(root); //将当前节点入栈
                root = root.left; // 移动到左子节点
            }
            // 2. 弹出栈顶节点（最左侧节点）
            root = stk.pop(); 
            res.add(root.val); // 访问节点值（中序遍历位置）
            root = root.right; //转向处理右子树

        }
        return res;
    }
}