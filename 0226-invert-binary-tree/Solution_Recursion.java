

public class Solution_Recursion {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        return root;
    }
    
}
