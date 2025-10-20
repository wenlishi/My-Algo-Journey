
public class Solution_Recursion {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    public int maxDepth(TreeNode root) {
        int maxDepth = 0;
        if (root == null) {
            return 0;
        }
        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);
        maxDepth = Math.max(leftMaxDepth, rightMaxDepth);

        return maxDepth + 1;
    }
    
}
