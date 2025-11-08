public class Solution_Dfs {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    // DFS 验证二叉搜索树
    public boolean isValidBST(TreeNode root) {
        // 这里使用 Long.MIN_VALUE 和 Long.MAX_VALUE 作为初始边界，避免节点值等于 Integer 边界值时出错
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
        
    }
    
    // 辅助函数，low 和 high 分别表示当前节点值的合法范围
    public boolean dfs(TreeNode root, long low, long high) {
        if (root == null) {
            return true;
        }

        // 如果当前节点值不在合法范围内，返回 false,因为 BST 要求左子树所有节点值小于根节点值，右子树所有节点值大于根节点值
        if (root.val <= low || root.val >= high) {
            return false;
        }

        // 递归检查左子树和右子树，更新合法范围
        return dfs(root.left, low, root.val) && dfs(root.right, root.val, high);
    }
}
