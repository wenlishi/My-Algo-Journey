public class Solution_Recursion {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }
    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        // 递归遍历左子树
        inorder(root.left, res);
        res.add(root.val);
        // 递归遍历右子树
        inorder(root.right, res);
    }
}